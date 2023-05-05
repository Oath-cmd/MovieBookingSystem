package Project;

public class Movie {

    private double price;
    private String name;
    private String genre;

    public Movie(String name, double price, String genre) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

	public double calculateTicketCost(int numSeats) {
		return 0;
	}
}
