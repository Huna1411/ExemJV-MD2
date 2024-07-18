package ra.entiny;

public class LaptopType {
    private static int nextId = 1;
    private int typeId;
    private String typeName;
    private String description;
    private boolean isDeleted;

    public LaptopType(String typeName, String description) {
        this.typeId = nextId++;
        this.typeName = typeName;
        this.description = description;
        this.isDeleted = false;
    }

    // Getters và Setters
    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}