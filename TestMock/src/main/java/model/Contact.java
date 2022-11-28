package model;

public class Contact {

    private Integer contactId;
    private String contactName;
    private Long contactNumber;

    public Integer getContactId() {
        return contactId;
    }

    public String getContactName() {
        return contactName;
    }

    public Long getContactNumber() {
        return contactNumber;
    }


    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }
}
