class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }
}
class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty = 0;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.price = price;
        this.authors = new Author[authors.length];
        for (int i = 0; i < authors.length; i++)
            this.authors[i] = authors[i];
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.authors = new Author[authors.length];
        System.arraycopy(authors, 0, this.authors, 0, authors.length);
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Book[name=\"" + name + "\", authors={");
        for (Author author : authors) {
            output.append(" Author[name=").append(author.getName())
                    .append(", email=").append(author.getEmail())
                    .append(", gender=").append(author.getGender())
                    .append("]");
        }
        output.append("}, price=").append(price).append(", qty=").append(qty).append("]");
        return output.toString();
    }

    public String getAuthorNames() {
        StringBuilder output = new StringBuilder();
        for (Author author : authors)
            output.append(author.getName() + " ");
        return output.toString();
    }
}



public class MainBook {
    public static void main(String[] args) {
        Author[] author = new Author[1];
        author[0] = new Author("Dmitry Glukhovsky", "DGlukhovsky@gmail.com", 'M');
        Book book = new Book("Metro 2033", author, 799.50, 3);
        System.out.println(book.toString());
        System.out.println(book.getAuthorNames());

        Author[] author1 = new Author[2];
        author1[0] = new Author("Zaitsev A.P.", "AZaitsev@ya.ru", 'M');
        author1[1] = new Author("Shelupanov A.A.", "AShelupanov@mail.ru", 'M');
        Book book1 = new Book("Technical means and methods of information protection", author1, 629.30);
        System.out.println(book1.toString());
        System.out.println(book1.getAuthorNames());
    }
}
