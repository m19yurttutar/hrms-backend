package kodlamaio.hrms.core.utilities.adapters.cloudinaryAdapter;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.apache.tomcat.util.http.fileupload.impl.SizeException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
    DataResult<Map> delete(String id) throws IOException;
}
