package com.xworkz.Oggy.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "oggy_table")
@NamedQuery(name="findByName", query="Select sa from Oggy sa where sa.name = 'Viji'")
@NamedQuery(name="findByRating", query="Select sa from Oggy sa where sa.rating = 80")
@NamedQuery(name = "findByFavoriteFoods", query = "SELECT sa.name FROM Oggy sa WHERE sa.favoriteFoods = :food")
@NamedQuery(name = "findByLevel", query = "SELECT sa.rating FROM Oggy sa WHERE sa.level = :levelk")
@NamedQuery(name = "findByGrade", query = "SELECT sa.isLazy FROM Oggy sa WHERE sa.grade = :grade")
@NamedQuery(name = "findAll", query = "SELECT sa FROM Oggy sa")


public class Oggy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private int age;
	private double weight;
	private char grade;
	private boolean isLazy;
	private long episodesWatched;
	private float height;
	private byte level;
	private short rating;
	private String favoriteFoods;

	public Oggy() {
	}

	public Oggy(String name, int age, double weight, char grade, boolean isLazy, long episodesWatched, float height,
			byte level, short rating, String favoriteFoods) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.grade = grade;
		this.isLazy = isLazy;
		this.episodesWatched = episodesWatched;
		this.height = height;
		this.level = level;
		this.rating = rating;
		this.favoriteFoods = favoriteFoods;
	}

	@Override
	public String toString() {
		return "OggyDTO{" + "name='" + name + '\'' + ", age=" + age + ", weight=" + weight + ", grade=" + grade
				+ ", isLazy=" + isLazy + ", episodesWatched=" + episodesWatched + ", height=" + height + ", level="
				+ level + ", rating=" + rating + ", favoriteFoods=" + favoriteFoods + '}';
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public boolean isLazy() {
		return isLazy;
	}

	public void setLazy(boolean isLazy) {
		this.isLazy = isLazy;
	}

	public long getEpisodesWatched() {
		return episodesWatched;
	}

	public void setEpisodesWatched(long episodesWatched) {
		this.episodesWatched = episodesWatched;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public byte getLevel() {
		return level;
	}

	public void setLevel(byte level) {
		this.level = level;
	}

	public short getRating() {
		return rating;
	}

	public void setRating(short rating) {
		this.rating = rating;
	}

	public String getFavoriteFoods() {
		return favoriteFoods;
	}

}
