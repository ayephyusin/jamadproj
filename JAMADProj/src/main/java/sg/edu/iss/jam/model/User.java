package sg.edu.iss.jam.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userID;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String dateOfBirth;
	
	private String displayName;
	
	private String about;
	
	private String profileUrl;
	
	private boolean enabled;
	
	//OneToMany relation with Roles
	@OneToMany(mappedBy = "roleUser", fetch= FetchType.EAGER)
	private Collection<Roles> roles;
	
	//OneToMany relation with Sessions
	@OneToMany(mappedBy = "sessionUser")
	private Collection<Sessions> sessions;
	
	//ManyToMany relation with Orders
	@OneToMany(mappedBy = "user")
	private Collection<Orders> orders;
	
	//oneToOne relation with wishlist
	@OneToOne(mappedBy = "wishlistUser")  
	private Wishlist wishlist;
	
	//relation with product 
	@OneToMany(mappedBy = "productUser")
	private Collection<Product> products;
	
	
	//OneToOne relation with shoppingcart
	@OneToOne(mappedBy = "shoppingCartUser")
	private ShoppingCart shoppingCart;
	
	//OneToMany relation with userhistory
	@OneToMany(mappedBy = "historyUser")
	private Collection<UserHistory> histories;
	
	//OneToMany relation with playlists
	@OneToMany(mappedBy = "playlistUser")
	private Collection<Playlists> playlists;
	
	//OneToMany relation with subscribed
	@OneToMany(mappedBy = "user")
	private Collection<Subscribed> subscribers;

	
	//OneToMany relation with channel
	@OneToMany(mappedBy = "channelUser")
	private Collection<Channel> channels;
	
	
	//OneToMany relation with comment
	@OneToMany(mappedBy = "commentUser")
	private Collection<Comments> comments;

	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String password, String dateOfBath, String displayName,
			String about, String profileUrl, Collection<Roles> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBath;
		this.displayName = displayName;
		this.about = about;
		this.profileUrl = profileUrl;
		this.roles = roles;
	}

	public Long getUserID() {
		return userID;
	}


	public void setUserID(Long userID) {
		this.userID = userID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDateOfBath() {
		return dateOfBirth;
	}


	public void setDateOfBath(String dateOfBath) {
		this.dateOfBirth = dateOfBath;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}


	public String getAbout() {
		return about;
	}


	public void setAbout(String about) {
		this.about = about;
	}


	public String getProfileUrl() {
		return profileUrl;
	}


	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}


	public Collection<Roles> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}


	public Collection<Sessions> getSessions() {
		return sessions;
	}


	public void setSessions(Collection<Sessions> sessions) {
		this.sessions = sessions;
	}


	public Collection<Orders> getOrders() {
		return orders;
	}


	public void setOrders(Collection<Orders> orders) {
		this.orders = orders;
	}


	public Wishlist getWishlist() {
		return wishlist;
	}


	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}


	public Collection<Product> getProducts() {
		return products;
	}


	public void setProducts(Collection<Product> products) {
		this.products = products;
	}


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	public Collection<UserHistory> getHistories() {
		return histories;
	}


	public void setHistories(Collection<UserHistory> histories) {
		this.histories = histories;
	}


	public Collection<Playlists> getPlaylists() {
		return playlists;
	}


	public void setPlaylists(Collection<Playlists> playlists) {
		this.playlists = playlists;
	}


	public Collection<Subscribed> getSubscribers() {
		return subscribers;
	}


	public void setSubscribers(Collection<Subscribed> subscribers) {
		this.subscribers = subscribers;
	}


	public Collection<Channel> getChannels() {
		return channels;
	}


	public void setChannels(Collection<Channel> channels) {
		this.channels = channels;
	}


	public Collection<Comments> getComments() {
		return comments;
	}


	public void setComments(Collection<Comments> comments) {
		this.comments = comments;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = true;
	}
	
	
	
	

}
