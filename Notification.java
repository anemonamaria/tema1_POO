public class Notification {
    private String notification;

    public Notification(){
        this.notification = "";
    }

    public Notification(String notification){
        this.notification = notification;
    }

    public String getNotification() {
        return notification;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notification='" + notification + '\'' +
                '}';
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
