package com.mycb.MyCB.object.modification;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class ModifyForm {

    private final static Object lock = new Object();

    protected String type;
    protected String query;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract Object[] runInsert();

    public abstract Object[] runUpdate();

    public abstract Object[] runDelete();

    public void run(JdbcTemplate jdbcTemplate) {
        synchronized (lock) {
            Object[] args;
            switch (type) {
                case "insert": {
                    args = runInsert();
                    break;
                }
                case "update": {
                    args = runUpdate();
                    break;
                }
                case "delete": {
                    args = runDelete();
                    break;
                }
                default: {
                    return;
                }
            }

            jdbcTemplate.update(query, args);
        }
    }
}
