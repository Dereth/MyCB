package com.mycb.MyCB.query;

import com.mycb.MyCB.query.QueryType;
import com.mycb.MyCB.webpage.Link;
import com.mycb.MyCB.webpage.Text;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class QueryScreen {

    private static final int DEFAULT_LIMIT;
    private static final int MAX_LIMIT;

    private String type;
    private String search;
    private String order;
    private String limit;
    private String page;

    private QueryArgs args;

    public void addArgs(String type, String search, String order, String limit, String page) {
        args = new QueryArgs();
        if (type == null && search == null && order == null && limit == null && page == null) {
            args.isNew = true;
        }
        args.canRun = true;

        if (type == null) {
            args.canRun = false;
        }
        else {
            args.type = parseType(type);
            if (args.type != null) {
                this.type = type;
            } else {
                args.canRun = false;
            }
        }

        this.search = search;
        args.search = search;
        if (args.type != null && args.type.hasArg() && args.search == null) {
            args.canRun = false;
        }

        args.ascending = false;
        if (order == null) {
            args.canRun = false;
        }
        else if (order.equals("asc")) {
            this.order = order;
            args.ascending = true;
        }
        else if (!order.equals("desc")) {
            args.canRun = false;
        }
        else {
            this.order = order;
        }

        if (limit == null) {
            this.limit = String.valueOf(DEFAULT_LIMIT);
            args.limit = DEFAULT_LIMIT;
            args.canRun = false;
        }
        else {
            switch (limit) {
                case "10": {
                    args.limit = 10;
                    this.limit = limit;
                    break;
                }
                case "50": {
                    args.limit = 50;
                    this.limit = limit;
                    break;
                }
                case "100": {
                    args.limit = 100;
                    this.limit = limit;
                    break;
                }
                case "500": {
                    args.limit = 500;
                    this.limit = limit;
                    break;
                }
                case "1000": {
                    args.limit = 1000;
                    this.limit = limit;
                    break;
                }
                default: {
                    this.limit = String.valueOf(DEFAULT_LIMIT);
                    try {
                        args.limit = Integer.parseInt(limit);
                        if (args.limit < 0) {
                            throw new NumberFormatException();
                        }
                        args.limit = Math.min(args.limit, MAX_LIMIT);
                    } catch (NumberFormatException e) {
                        args.limit = DEFAULT_LIMIT;
                        args.canRun = false;
                    }
                }
            }
        }

        try {
            args.page = Integer.parseInt(page);
            if (args.page < 0) {
                throw new NumberFormatException();
            }
            this.page = page;
        } catch (NumberFormatException | NullPointerException e) {
            args.page = 0;
            this.page = "0";
            args.canRun = false;
        }

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void fillModel(Model model, JdbcTemplate jdbcTemplate) {

        if (args.canRun) {
            List<?> results;

            if (args.limit == 0) {
                results = new ArrayList<>();
            }
            else if (args.type.hasArg()) {
                results = jdbcTemplate.query(args.type.getQuery(), getMapper(), args.search);
            }
            else {
                results = jdbcTemplate.query(args.type.getQuery(), getMapper());
            }

            int size = Math.min(Math.max(results.size() - args.limit * args.page, 0), args.limit);
            int s = args.ascending ? args.limit * args.page : results.size() - 1 - args.limit * args.page;
            int step = args.ascending ? 1 : -1;
            List<Object> processed = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                processed.set(i, results.get(s));
                s += step;
            }

            model.addAttribute("results", processed);
            String tempPage = page;
            if (args.page > 0 && results.size() > 0) {
                page = String.valueOf(args.page-1);
                model.addAttribute("prev", new Link(getRedirect(), "Prev"));
            }
            else {
                model.addAttribute("prev", null);
            }

            if (args.page * args.limit > results.size() && size == args.limit) {
                page = String.valueOf(args.page+1);
                model.addAttribute("next", new Link(getRedirect(), "Next"));
            }
            else {
                model.addAttribute("next", null);
            }

            page = tempPage;

            if (results.size() == 0) {
                model.addAttribute("feedback", new Text("No results"));
            }
            else if (size == 0) {
                model.addAttribute("feedback", new Text("No results on this page"));
            }
            else {
                model.addAttribute("feedback", null);
            }
        }
        else if (args.isNew) {
            model.addAttribute("feedback", new Text("Press GO! to search"));
        }
        else {
            model.addAttribute("feedback", new Text("Invalid Search; Were you messing with the URL?"));
        }

    }

    public String getRedirect() {
        StringBuilder builder = new StringBuilder();
        boolean isComplete = true;
        if (type != null) {
            builder.append("&type=").append(type);
        }
        else {
            isComplete = false;
        }
        if (search != null) {
            builder.append("&search=").append(search);
        }
        else {
            isComplete = false;
        }
        if (order != null) {
            builder.append("&order=").append(order);
        }
        else {
            isComplete = false;
        }
        if (limit != null) {
            builder.append("&limit=").append(limit);
        }
        else {
            isComplete = false;
        }
        if (page != null) {
            builder.append("&page=").append(page);
        }
        else if (isComplete) {
            builder.append("&page=0");
        }

        if (builder.length() != 0) {
            builder.setCharAt(0, '?');
        }
        return builder.toString();
    }

    public abstract QueryType parseType(String type);
    public abstract RowMapper<?> getMapper();

    static {
        DEFAULT_LIMIT = 100;
        MAX_LIMIT = 1000;
    }

    private static class QueryArgs {

        boolean canRun;
        boolean isNew;
        QueryType type;
        String search;
        boolean ascending;
        int limit;
        int page;

    }

}
