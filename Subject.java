public interface Subject {
    //Observer pattern
    public void addObserver(User user);

    public void removeObserver(User c);

    public void notifyAllObservers();
}
