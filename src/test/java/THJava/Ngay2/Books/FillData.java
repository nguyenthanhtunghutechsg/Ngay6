package THJava.Ngay2.Books;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import THJava.Ngay2.Books.Models.Book;
import THJava.Ngay2.Books.Models.Category;
import THJava.Ngay2.Books.Repositories.BookRepository;
import THJava.Ngay2.Books.Repositories.CategoryRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class FillData {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void testCreateUser() {
		Category categoryCNTT = new Category(); 
		categoryCNTT.setName("Cong Nghe Thong Tin");
		categoryRepository.save(categoryCNTT);
		Category categoryEng = new Category(); 
		categoryEng.setName("Tieng Anh");
		categoryRepository.save(categoryEng);

		Book bookCNTT1 = new Book();
		bookCNTT1.setTitle("Lap trinh web spring MVC");
		bookCNTT1.setAuthor("Anh Nguyen");
		bookCNTT1.setPrice(50000l);
		bookCNTT1.setCategory(categoryCNTT);
		bookRepository.save(bookCNTT1);
		
		Book bookCNTT2 = new Book();
		bookCNTT2.setTitle("Lap trinh Ung dung Spring");
		bookCNTT2.setAuthor("Anh Nguyen");
		bookCNTT2.setPrice(150000l);
		bookCNTT2.setCategory(categoryCNTT);
		bookRepository.save(bookCNTT2);
		
		Book bookCNTT3 = new Book();
		bookCNTT3.setTitle("Lap trinh ung dung java");
		bookCNTT3.setAuthor("Anh Nguyen");
		bookCNTT3.setPrice(250000l);
		bookCNTT3.setCategory(categoryCNTT);
		bookRepository.save(bookCNTT3);
		
		Book bookEng1 = new Book();
		bookEng1.setTitle("IELTS");
		bookEng1.setAuthor("Cambridge");
		bookEng1.setPrice(350000l);
		bookEng1.setCategory(categoryEng);
		bookRepository.save(bookEng1);
		assertThat("1").isEqualTo("1");
	}
	
}
