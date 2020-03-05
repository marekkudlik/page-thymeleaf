package marek.poznan.pagethymeleaf.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "page")
public class Page {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = "is required")
	@Size(min = 1, max = 30)
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 1, max = 30)
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "opinion")
	private String opinion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "next_date")
	private Date nextDate;

	@DateTimeFormat(pattern = "HH:mm:ss")
	@Temporal(TemporalType.TIME)
	@Column(name = "next_time")
	private Date nextTime;

	@NotNull(message = "is required")
	@Size(min = 1, max = 30)
	@Column(name = "email")
	private String email;

	public Page() {

	}

	public Page(int id, String firstName, String lastName, String opinion, Date nextDate, Date nextTime, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.opinion = opinion;
		this.nextDate = nextDate;
		this.nextTime = nextTime;
		this.email = email;
	}
	

	public Page(@NotNull(message = "is required") @Size(min = 1, max = 30) String firstName,
			@NotNull(message = "is required") @Size(min = 1, max = 30) String lastName, String opinion,
			@NotNull(message = "is required") @Size(min = 1, max = 30) String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.opinion = opinion;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Date getNextDate() {
		return nextDate;
	}

	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", opinion=" + opinion
				+ ", nextDate=" + nextDate + ", nextTime=" + nextTime + ", email=" + email + "]";
	}

}
