package com.mycb.MyCB.object.modification;

public class ModifyCoachForm extends ModifyForm {

    private String coachId;
    private String name;

    @Override
    public Object[] runInsert() {
        this.query = "INSERT INTO Coaches VALUES(?, ?);";
        return new Object[] {coachId, name};
    }

    @Override
    public Object[] runUpdate() {
        this.query = "UPDATE Coaches SET name = ? WHERE coach_id = ?";
        return new Object[] {name, coachId};
    }

    @Override
    public Object[] runDelete() {
        this.query = "DELETE FROM Coaches WHERE coach_id = ?;";
        return new Object[] {coachId};
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
