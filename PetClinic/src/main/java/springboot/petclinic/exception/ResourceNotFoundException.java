package springboot.petclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Customexception

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String resourceName;
	private String fieldName;
	private Object fieldvalue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long id) {
			super(String.format("%s not found with %s:'%s'",resourceName,fieldName,id));
			this.resourceName = resourceName;
			this.fieldName = fieldName;
			this.fieldvalue = id;
		}
		
		
	//getterMethods
		public String getResourceName() {
			return resourceName;
		}

		public String getFieldName() {
			return fieldName;
		}

	public Object getFieldvalue() {
			return fieldvalue;
		}


	

}

