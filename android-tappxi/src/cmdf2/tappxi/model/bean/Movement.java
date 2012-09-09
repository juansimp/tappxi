package cmdf2.tappxi.model.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Movement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private Date datetime;
	private float amount;
	private int type;

	public Movement(int id, User user, Date datetime, float amount, int type) {
		super();
		this.id = id;
		this.user = user;
		this.datetime = datetime;
		this.amount = amount;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public static Movement fromJSONObject(JSONObject object) throws JSONException, ParseException {
		return new Movement(object.getInt("id"), User.fromJSONObject(object.getJSONObject("user")), new SimpleDateFormat("yyyy-MM-dd").parse(object.getString("datetime")), (float)object.getDouble("amount"), object.getInt("type"));
	}

}
