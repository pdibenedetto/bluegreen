package org.springframework.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ryan Baxter
 */
@RestController
public class ColorController {

	private ColorProperties colorProperties;

	public  ColorController(ColorProperties colorProperties) {
		this.colorProperties = colorProperties;
	}

	@RequestMapping
	public Color color() {
		if(Color.BLUE.getId().equalsIgnoreCase(colorProperties.getColor())) {
			return Color.BLUE;
		}
		return Color.GREEN;
	}

	static class Color {
		public static final Color GREEN = new Color("green");
		public static final Color BLUE = new Color("blue");
		private String id;

		public Color(){}

		public Color(String id) { this.id = id; }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
	}
}
