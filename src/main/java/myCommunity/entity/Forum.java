package myCommunity.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CommunityForum")
public class Forum {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;		
	private Integer parentId;
	@ManyToOne
	@JoinColumn(name="ParentId")
	private Forum forum;
	@OneToMany(mappedBy="forum")
	private List<Forum> list;
	
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public List<Forum> getList() {
		return list;
	}
	public void setList(List<Forum> list) {
		this.list = list;
	}
	public Forum() {}
	public Forum(int id, String name, String description, Integer parentId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	

}
