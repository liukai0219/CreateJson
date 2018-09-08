package co.nuoya.JsonDB.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import co.nuoya.JsonDB.model.Acount;
import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.model.Tags;

public class CustomerAdapter extends TypeAdapter<Customer> {

	@Override
	public void write(JsonWriter out, Customer value) throws IOException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = "";
		value.toString();//触发懒加载
		out.beginObject();
		out.name("_id").value(value.getId());
		out.name("index").value(value.getIndex());
		out.name("guid").value(value.getGuid());
		out.name("isActive").value(value.isActive());
		
		//acount是一个对象
		out.name("acount").beginObject();
		out.name("acount_id").value(value.getAccout().getAcount_id());
		out.name("balance").value(value.getAccout().getBalance());
		if (value.getAccout().getCreated()!=null) {
			dateString = formatter.format(value.getAccout().getCreated());
			out.name("created").value(dateString);
			out.name("createdby").value(value.getAccout().getCreatedby());
		}
		if (value.getAccout().getUpdate()!=null) {
			dateString = formatter.format(value.getAccout().getUpdate());
			out.name("update").value(dateString);
			out.name("updateby").value(value.getAccout().getUpdateby());
		}
		out.endObject();
		
		out.name("picture").value(value.getPicture());
		out.name("age").value(value.getAge());
		out.name("eyeColor").value(value.getEyecolor());
		out.name("lastName").value(value.getLastName());
		out.name("company").value(value.getCompany());
		out.name("email").value(value.getEmail());
		out.name("phone").value(value.getPhone());
		out.name("address").value(value.getAddress());
		out.name("about").value(value.getAbout());
		
		//tags是一个集合
		out.name("tags").beginArray();
		for( final Tags tag : value.getTags()) {
			out.beginObject();
			out.name("id").value(tag.getId());
			out.name("customer_id").value(tag.getCustomer_id());
			out.name("tag").value(tag.getTag());
			if (tag.getCreated()!=null) {
				dateString = formatter.format(tag.getCreated());
				out.name("created").value(dateString);
				out.name("createdby").value(tag.getCreatedby());
			}
			if (tag.getUpdate()!=null) {
				dateString = formatter.format(tag.getUpdate());
				out.name("update").value(dateString);
				out.name("updateby").value(tag.getUpdateby());
			}
			out.endObject();
		}
		out.endArray();
		
		out.name("favoriteFruit").value(value.getFavoriteFruit());
		if (value.getUpdate()!=null) {
			dateString = formatter.format(value.getUpdate());
			out.name("created").value(dateString);
			out.name("createdby").value(value.getCreatedby());
		}
		
		if (value.getUpdate()!=null) {
			dateString = formatter.format(value.getUpdate());
			out.name("update").value(dateString);
			out.name("updateby").value(value.getUpdateby());
		}
		out.endObject();//如果没有调用 out.endObject(),会报出 JsonSyntaxException错误
	}

	@Override
	public Customer read(JsonReader in) throws IOException {
		final Customer customer = new Customer();
		in.beginObject();
		while(in.hasNext()) {
			switch(in.nextName()) {
			case "operate":
				customer.setOperate(in.nextString());
				break;
			case "_id" :
				customer.setId(in.nextString());
				break;
			case "index" :
				customer.setIndex(in.nextString());
				break;
			case "guid" :
				customer.setGuid(in.nextString());
				break;
			case "isActive" :
				customer.setActive(in.nextBoolean());
				break;
			//对象
			case "acount" :
				in.beginObject();
				final Acount acount = new Acount();
			    while (in.hasNext()) {
			    	switch(in.nextName()) {
				    	case "acount_id" :
				    		acount.setAcount_id(in.nextString());
				    		break;
				    	case "balance" :
				    		acount.setBalance(in.nextString());
				    		break;
				    	default :
				    		in.skipValue();
				    		break;
					}
			    }
				customer.setAccout(acount);
				in.endObject();
				break;
			case "picture" :
				customer.setPicture(in.nextString());
				break;
			case "age" :
				customer.setAge(in.nextInt());
				break;
			case "eyeColor" :
				customer.setEyecolor(in.nextString());
				break;
			case "firstName" :
				customer.setFirstName(in.nextString());
				break;
			case "lastName" :
				customer.setLastName(in.nextString());
				break;
			case "company" :
				customer.setCompany(in.nextString());
				break;
			case "email" :
				customer.setEmail(in.nextString());
				break;
			case "phone" :
				customer.setPhone(in.nextString());
				break;
			case "address" :
				customer.setAddress(in.nextString());
				break;
			case "about" :
				customer.setAbout(in.nextString());
				break;
			//数组
			case "tags" :
				in.beginArray();
				final List<Tags> list = new ArrayList<Tags>();
				while (in.hasNext()) {
					in.beginObject();
					final Tags tag = new Tags();
					while (in.hasNext()) {
						switch (in.nextName()) {
							case "id" :
								tag.setId(in.nextString());
								break;
							case "tag" :
								tag.setTag(in.nextString());
								break;
							default :
					    		in.skipValue();
					    		break;
						}
					}
					list.add(tag);
					in.endObject();
				}
				in.endArray();
				customer.setTags(list);
				break;
			case "favoriteFruit" :
				customer.setFavoriteFruit(in.nextString());
				break;
			default:
				in.skipValue();
				break;
			}
		}
		in.endObject();
		return customer;
	}

}
