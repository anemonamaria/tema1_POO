public class User {
    private final String firstName; // required
    private final String lastName; // required
    private final int age; //optional
    private final String phone; // optional
    private final String address; //optional

    private User(UserBuilder builer) {
        this.firstName = builer.firstName;
        this.lastName = builer.lastName;
        this.age = builer.age;
        this.phone = builer.phone;
        this.address = builer.address;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return age;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public String toString(){
        return "User:" + this.firstName + " " + this.lastName + " " +
                this.age + " " + this.phone + " " + this.address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();
        User user2 = new User.UserBuilder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();
    }
}