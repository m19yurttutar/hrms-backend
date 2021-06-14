package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface AuthService<TEntity> {
    Result register(TEntity entity);
}
