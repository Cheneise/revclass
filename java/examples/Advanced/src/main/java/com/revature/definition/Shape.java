package com.revature.definition;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.revature.exceptions.NullColorError;

/**
 * The natural order of all Shapes is the name.
 */
public abstract class Shape implements Calculable, Comparable<Shape>, Serializable {
	
	/**
	 * Compatibility with Java 1.x
	 */
	private static final long serialVersionUID = -750221678522588868L;

	private static final Logger LOGGER = Logger.getLogger(Shape.class);
	
	protected final String name;
	//Add and remove the transient keyword so you can see how color is or is not stored.
	protected transient final Color color;
	
	/**
	 * 
	 * @throws NullColorError - if color is null
	 */
	public Shape(String name, Color color) {
		//super(); -----> Implicit!
		LOGGER.trace("Args shape");
		
		/*
		 * It's unchecked, so applies the same as RuntimeException, but represents something different.
		 */
		if(color == null) {
			throw new NullColorError("A shape must have a color, application should stop immediately.");
		}
		
		this.name = name;
		this.color = color;
	}
	
	/**
	 * Prints a brief explanation of the Shape
	 */
	protected abstract void describe();

	/*
	 * Fields of this class are immutable, no setters.
	 */
	
	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Shape shape) {
		return this.name.compareTo(shape.name);
	}
	
	@Override
	protected void finalize() throws Throwable {
		LOGGER.info("Shape with the " + color.getName() + " being collected.");
	}
}
