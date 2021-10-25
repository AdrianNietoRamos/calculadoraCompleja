package calculadoraCompleja;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Complejo {

	private DoubleProperty real=new SimpleDoubleProperty();
	private DoubleProperty imaginario=new SimpleDoubleProperty();
	
	public final DoubleProperty realProperty() {
		return real;
	}
	



	public double getReal() {
		return this.realProperty().get();
	}
	



	public void setReal(final double real) {
		this.realProperty().set(real);
	}
	



	public DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}
	



	public double getImaginario() {
		return this.imaginarioProperty().get();
	}
	



	public void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}
	
	
	@Override
	public String toString() {
		return "("+getReal()+","+getImaginario()+")";
		
	}
	//(a+c, b+d)
	public Complejo sumar(Complejo suma) {
		Complejo s=new Complejo();
		s.realProperty().bind(realProperty().add(suma.realProperty()));
		s.imaginarioProperty().bind(imaginarioProperty().add(suma.imaginarioProperty()));
		
		return s;
	}
	//(a-c, b-d)
public Complejo restar(Complejo resta) {
	Complejo r=new Complejo();
	r.realProperty().bind(realProperty().subtract(resta.realProperty()));
	r.imaginarioProperty().bind(imaginarioProperty().subtract(resta.imaginarioProperty()));
	
	return r;
	}
//(a*c - b*d, a*d + b*c)
public Complejo multiplicar(Complejo multi) {
	Complejo m=new Complejo();
	m.realProperty().bind(realProperty().multiply(multi.realProperty())
			.subtract(imaginarioProperty().multiply(multi.imaginarioProperty())));
	m.imaginarioProperty().bind(realProperty().multiply(multi.imaginarioProperty())
			.add(imaginarioProperty().multiply(multi.realProperty())));
	
	return m;
}
//((a*c+b*d)/c*c+d*d),((b*c-a*d)/c*c+d*d)
public Complejo dividir(Complejo divide) {
	Complejo d=new Complejo();
	d.realProperty().bind((realProperty()
			.multiply(divide.realProperty())
			.add(imaginarioProperty().multiply(divide.imaginarioProperty())))
			.divide(divide.realProperty().multiply(divide.realProperty()).add(divide.imaginarioProperty().multiply(divide.imaginarioProperty()))));
	
	d.imaginarioProperty().bind((imaginarioProperty()
			.multiply(divide.realProperty())
			.subtract(realProperty().multiply(divide.imaginarioProperty())))
			.divide(divide.realProperty().multiply(divide.realProperty()).add(divide.imaginarioProperty().multiply(divide.imaginarioProperty()))));
	
	
	return d;
}
	



	
	
	
	
}
