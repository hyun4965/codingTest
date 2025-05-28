package lab.coffee;

abstract class Coffee {
    protected String description = "Empty";
    public String getDescription(){ return description; }
    public abstract double cost();
}
