package project.hwanvis.hawnvisserver.domain;

public enum Vendor {
    GPT("gpt"),
    CLAUDE("claude"),
    UNKNOWN("unknown");
    ;
    private final String name;

    Vendor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isNameEqual(String vendorName) {
        return this.name.equals(vendorName);
    }
}
