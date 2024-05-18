package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.books.BookForLoan;
import entities.books.Comic;
import entities.books.Novel;

public class RepositoryBookForLoan {
        public List<BookForLoan> getAllBook() {

                List<String> authorList = new ArrayList<String>() {
                        {
                                add("Masashi Kisimoto");
                                add("Yoshihiro Togashi");
                                add("J.K Rowling");
                                add("Tere Liye");
                                add("Dee Lestari");
                        }
                };

                List<BookForLoan> bookList = new ArrayList<BookForLoan>() {
                        {
                                add(new Comic("Comic-001", "Uzumaki Naruto", "Shounen", authorList.get(0), 55000, 10));
                                add(new Comic("Comic-002", "The Worst Client", "Shounen", authorList.get(0), 35000,
                                                20));
                                add(new Comic("Comic-003", "For the Sake of Dreams...!!", "Shounen", authorList.get(0),
                                                35000, 15));
                                add(new Comic("Comic-004", "Hunter X Hunter : The Day of Departure", "Fantasy",
                                                authorList.get(1),
                                                50000, 15));
                                add(new Comic("Comic-005", "Hunter X Hunter : A Struggle in the Mist", "Fantasy",
                                                authorList.get(1),
                                                80000, 25));

                                add(new Novel("Novel-001", "Harry Potter and the Philosopher's Stone", true,
                                                authorList.get(2), 150000,
                                                10));
                                add(new Novel("Novel-002", "Harry Potter and the Chamber of Secrets", true,
                                                authorList.get(2), 150000,
                                                10));
                                add(new Novel("Novel-003", "Harry Potter and the Prisoner of Azkaban", true,
                                                authorList.get(2), 200000,
                                                15));
                                add(new Novel("Novel-004", "Ayah Aku Berbeda", false, authorList.get(3), 35000,
                                                15));
                                add(new Novel("Novel-005", "Madre", false, authorList.get(4), 80000,
                                                10));

                        }

                };

                return bookList;
        }

}
