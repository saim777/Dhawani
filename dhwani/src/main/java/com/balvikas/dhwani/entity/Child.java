package com.balvikas.dhwani.entity;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="Child")
	public class Child {
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		
		@Column(name="childName")
		private String childName;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getChildName() {
			return childName;
		}

		public void setChildName(String childName) {
			this.childName = childName;
		}
		
		
}
