package robert.persistence.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BasicEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String uuid = UUID.randomUUID().toString();

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		BasicEntity that = (BasicEntity) o;
		return hashCode() == that.hashCode();
	}

	@Override
	public int hashCode() {
		return uuid.hashCode();
	}

}