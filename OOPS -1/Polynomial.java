/*
	Implement a polynomial class, that contains following functions -
1. setCoefficient -
This function sets coefficient for a particular degree value. If term with given degree is not there in the polynomial, then corresponding term (with specified degree and value) is added. If the term is already present in the polynomial, then previous coefficient value is replaced by given coefficient value.
2. add -
Adds two polynomials and returns a new polynomial which has the result.
3. subtract -
Subtracts two polynomials and returns a new polynomial which has the result.
4. multiply -
Multiplies two polynomials and returns a new polynomial which has the result.
5. print -
Prints all the terms (only terms with non zero coefficients are to be printed) in increasing order of degree.
Print pattern for a single term : "x"
And multiple terms should be printed separated by space. For more clarity, refer sample test cases.
Note : Only keep those terms which have non - zero coefficients.
*/

public class Polynomial {

	DynamicArray arr;

	public Polynomial(){
	    arr = new DynamicArray();
	}

	/* This function sets coefficient for a particular degree value, if degree is not there in the polynomial
	 *  then corresponding term(with specified degree and value is added int the polynomial. If the degree
	 *  is already present in the polynomial then previous coefficient is replaced by
	 *  new coefficient value passed as function argument
	*/
    public void setCoefficient(int degree, int coeff){
		arr.set(degree, coeff);
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i=0;i<this.arr.size(); i++){
			int p = this.arr.get(i);
			if(p!=0) System.out.print(p + "x" + i + " ");
		}
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
		Polynomial p3 = new Polynomial();
		int larger = this.arr.size() > p.arr.size() ? this.arr.size() : p.arr.size();
		for(int i=0;i<larger;i++) p3.setCoefficient(i, this.arr.get(i)+p.arr.get(i));

		return p3;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
		Polynomial p3 = new Polynomial();
		int larger = this.arr.size() > p.arr.size() ? this.arr.size() : p.arr.size();
		for(int i=0;i<larger;i++) p3.setCoefficient(i, this.arr.get(i)-p.arr.get(i));

		return p3;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		Polynomial p3 = new Polynomial();
		for(int i=0;i<this.arr.size();i++){
			int a1 = this.arr.get(i);
			if(a1 == 0) continue;
			for(int j=0;j<p.arr.size();j++){
				int a2 = p.arr.get(j);
				if(a2 != 0){ int temp = p.arr.get(i+j);
					 p3.setCoefficient(i+j, temp + a1*a2);
				}
			}
		}
		return p3;
	}
}
