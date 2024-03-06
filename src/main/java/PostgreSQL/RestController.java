package PostgreSQL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	public MyRepo repo;
	
	@PostMapping("/emp")
	public Emp add(@RequestBody Emp e) {
		return this.repo.save(e);
	}
	
	@GetMapping("/emp")
	public List<Emp> showAll(){
		return (List<Emp>) repo.findAll();
	}
	
	@GetMapping("/emp/{id}")
	public Emp search(@PathVariable int id){
		return this.repo.findById(id).orElse(null);
	}
	
	@DeleteMapping("/emp/{id}")
	public String delete(@PathVariable int id){
		Emp eid = this.repo.findById(id).orElse(null);
		if (eid != null) {
			repo.delete(eid);
		}
		return "Deleteed";
	}
	
	@PutMapping("/emp/{id}")
	public Emp update(@PathVariable int id,@RequestBody Emp e) {
		e.setId(id);
		return this.repo.save(e);
	}
}
