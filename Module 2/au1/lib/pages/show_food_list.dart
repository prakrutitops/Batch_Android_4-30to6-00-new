import 'package:flutter/material.dart';

import '../food_card.dart';
import '../model/cart_model.dart';
import '../model/food_model.dart';

class ShowFoodList extends StatelessWidget {
  final CartModel value;
  const ShowFoodList({super.key, required this.value});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: const EdgeInsets.all(14),
      child: Column(
        children: [
          buildAppBar(),
          buildFoodFilter(),
          buildFoodList(value, context),
        ],
      ),
    );
  }
}

Widget buildAppBar() {
  return SafeArea(
    child: Row(
      children: [
        const Text(
          'MENU',
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
        ),
        const Spacer(),
        IconButton(
          onPressed: () {},
          icon: const Icon(Icons.search),
        ),
        IconButton(
          onPressed: () {},
          icon: const Icon(Icons.filter_alt_outlined),
        ),
      ],
    ),
  );
}

Widget buildFoodFilter() {
  List<String> foodFilter = [
    'Pizza',
    'Burger',
    'Punjabi',
    'North Indian',
    'South Indian',
    'Chiniese'
  ];
  return SizedBox(
    height: 50,
    child: ListView.builder(
      shrinkWrap: true,
      scrollDirection: Axis.horizontal,
      physics: const BouncingScrollPhysics(),
      itemCount: foodFilter.length,
      itemBuilder: (context, index) {
        return Padding(
          padding: const EdgeInsets.all(8.0),
          child: ChoiceChip(
            showCheckmark: false,
            label: Text(foodFilter[index]),
            selected: true,
            selectedColor: Colors.yellow,
            onSelected: (value) {},
          ),
        );
      },
    ),
  );
}

Widget buildFoodList(CartModel? cartModel, BuildContext context) {
  return Expanded(
      child: GridView.count(
    crossAxisCount: 2,
    childAspectRatio: 0.55,
    mainAxisSpacing: 4,
    crossAxisSpacing: 4,
    physics: const BouncingScrollPhysics(),
    children: List.generate(
      foodItems.length,
      (index) => FoodCard(
        image: foodItems[index].image,
        name: foodItems[index].name,
        price: foodItems[index].price,
        rating: foodItems[index].rating,
        onTap: () {
          var food = Food(
            image: foodItems[index].image,
            name: foodItems[index].name,
            discription: foodItems[index].discription,
            price: foodItems[index].price,
            rating: foodItems[index].rating,
          );
          cartModel!.addToCart(food);
          print(cartModel!.cart);
        },
      ),
    ),
  ));
}
