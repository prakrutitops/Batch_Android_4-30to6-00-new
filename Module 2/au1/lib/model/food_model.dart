class Food {
  final String image;
  final String name;
  final String discription;
  final double price;
  final int rating;

  const Food(
      {required this.image,
      required this.name,
      required this.discription,
      required this.price,
      required this.rating});
}

List<Food> foodItems = [
  const Food(
    image: 'assets/images/dish1.png',
    name: "Vegetable and Poached Egg",
    discription: "",
    price: 13.90,
    rating: 4,
  ),
  const Food(
    image: 'assets/images/dish2.png',
    name: "Vegetable and Poached Egg",
    discription: "",
    price: 13.90,
    rating: 4,
  ),
  const Food(
    image: 'assets/images/dish3.png',
    name: "Vegetable and Poached Egg",
    discription: "",
    price: 13.90,
    rating: 4,
  ),
  const Food(
    image: 'assets/images/dish4.png',
    name: "Vegetable and Poached Egg",
    discription: "",
    price: 13.90,
    rating: 4,
  ),
];
