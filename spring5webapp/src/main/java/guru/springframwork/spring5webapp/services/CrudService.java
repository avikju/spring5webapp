package guru.springframwork.spring5webapp.services;

import org.springframework.data.repository.CrudRepository;

import guru.springframwork.spring5webapp.annotation.LogExecutionTime;

public interface CrudService<T, ID> {

	CrudRepository<T, ID> getCrudRepo();

	@LogExecutionTime
	default T create(T t) {
		getCrudRepo().save(t);
		return t;
	}

	@LogExecutionTime
	default Iterable<T> create(Iterable<T> t) {
		return getCrudRepo().saveAll(t);
	}

	default T readById(ID id) {
		return getCrudRepo().findById(id).get();
	}

	default T update(T t) {
		return getCrudRepo().save(t);
	}

	default void deleteById(ID id) {
		getCrudRepo().deleteById(id);
	}

	default Iterable<T> findAll() {
		return getCrudRepo().findAll();
	}

}
