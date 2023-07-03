package JavaAccModFirst;

// Vì class Car là final class nên class Honda không được kế thừa class Car
// Cùng package hay khác package cũng đều giống nahau
// Muốn kế thừa được class Car thì remove final đi
// Không kế thừa được nhưng vẫn khởi tạo được
public class Honda {
	Car car= new Car();

}
