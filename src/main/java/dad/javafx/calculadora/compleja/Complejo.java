package dad.javafx.calculadora.compleja;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {
	
	private DoubleProperty real = new SimpleDoubleProperty(0);
	private DoubleProperty imaginario = new SimpleDoubleProperty(0);
	
	public Complejo() {}
	
	public Complejo(double real, double imaginario) {
		super();
		setReal(real);
		setImaginario(imaginario);
	}
	
	public final DoubleProperty realProperty() {
		return this.real;
	}
	
	public final double getReal() {
		return this.realProperty().get();
	}
	
	public final void setReal(final double real) {
		this.realProperty().set(real);
	}
	
	public final DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}
	
	public final double getImaginario() {
		return this.imaginarioProperty().get();
	}
	
	public final void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}

	@Override
	public String toString() {
		return getReal() + "+" + getImaginario() + "i";
	}
	
	public Complejo add(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().add(c.realProperty()));
		r.imaginarioProperty().bind(imaginarioProperty().add(c.imaginarioProperty()));
		return r;
	}
	
	public Complejo substract(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().subtract(c.realProperty()));
		r.imaginarioProperty().bind(imaginarioProperty().subtract(c.imaginarioProperty()));
		return r;
	}
	
	public Complejo multiply(Complejo c) {
		Complejo r = new Complejo();
		DoubleProperty real1 = realProperty();
		DoubleProperty real2 = c.realProperty();
		DoubleProperty imaginario1 = imaginarioProperty();
		DoubleProperty imaginario2 = c.imaginarioProperty();
		
		r.realProperty().bind(real1.multiply(real2)
				.subtract(
						imaginario1.multiply(imaginario2))
		);
		r.imaginarioProperty().bind(real1.multiply(imaginario2)
				.add(
						imaginario1.multiply(real2)));
		return r;
	}
	
	public Complejo divide(Complejo c) {
		Complejo r = new Complejo();
		DoubleProperty real1 = realProperty();
		DoubleProperty real2 = c.realProperty();
		DoubleProperty imaginario1 = imaginarioProperty();
		DoubleProperty imaginario2 = c.imaginarioProperty();
		
		DoubleProperty potenciaRealB = new SimpleDoubleProperty(0);
		DoubleProperty potenciaImaginarioB = new SimpleDoubleProperty(0);
		
		potenciaRealB.bind(real2.multiply(real2));
		potenciaImaginarioB.bind(imaginario2.multiply(imaginario2));
		
		r.realProperty().bind((real1.multiply(real2).add(imaginario1.multiply(imaginario2)))
				.divide(potenciaRealB.add(potenciaImaginarioB))
		);
		
		r.imaginarioProperty().bind((imaginario1.multiply(real2).subtract(real1.multiply(imaginario2)))
				.divide(potenciaRealB.add(potenciaImaginarioB))
		);
		
		return r;
	}
	
	public static void main(String[] args) {
		Complejo a = new Complejo(1, 2);
		Complejo b = new Complejo(3, 4);
//		Complejo c = a.multiply(b);
		Complejo c = a.divide(b);
		
		System.out.println(c);
		
		a.setReal(7);
		a.setImaginario(2);
		
		b.setReal(4);
		b.setImaginario(1);
		
		System.out.println(c);
	}
	
}


