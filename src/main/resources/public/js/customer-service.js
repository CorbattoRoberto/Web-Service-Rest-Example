const path="/customers/v1"

class CustomerService {
	
	constructor() { }

	static getAll() {
		return BaseService.getAll(path);
	}
	
	static post(formData) {
		return BaseService.post(path, formData);
	}
	
	static delete(idCustomer) {
		return BaseService.delete(path, idCustomer);
	}
	
	static put(formData) {
		return BaseService.put(path, formData);
	}
	
}
