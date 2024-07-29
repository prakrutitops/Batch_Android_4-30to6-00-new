import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../model/cart_model.dart';

class CartPage extends StatelessWidget {
  const CartPage({super.key});

  buildAppBarCart() {
    return const SafeArea(
        child: Row(
      children: [
        Text(
          "Cart",
          style: TextStyle(fontSize: 28),
        )
      ],
    ));
  }

  Widget buildCartList(CartModel? value) {
    return Column(children: [
      Expanded(
        child: ListView.builder(
          itemCount: value!.cart.length,
          itemBuilder: (context, index) {
            return Padding(
              padding: const EdgeInsets.all(8.0),
              child: ListTile(
                leading: ClipRRect(
                    child: Image.asset(
                  value.cart[index].image,
                  width: 60,
                  height: 60,
                  fit: BoxFit.cover,
                )),
                title: Text(value.cart[index].name),
                trailing: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    Text('\$${value.cart[index].price}'),
                    Icon(Icons.add)
                  ],
                ),
              ),
            );
          },
        ),
      ),
      Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(
            'Total',
            style: TextStyle(fontSize: 28),
          ),
          Text(
            '\$${value.cart.fold(0, (previousValue, element) => previousValue + element.price.toInt())}',
            style: TextStyle(fontSize: 28),
          ),
        ],
      ),
      GestureDetector(
        onTap: () {},
        child: Container(
          height: 50,
          decoration: BoxDecoration(
            color: Colors.yellow,
          ),
          child: Center(
            child: Text("Checkout"),
          ),
        ),
      )
    ]);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Consumer<CartModel>(
        builder: (context, value, child) => Container(
          margin: const EdgeInsets.all(14),
          child: Column(
            children: [
              buildAppBarCart(),
              Expanded(child: buildCartList(value)),
            ],
          ),
        ),
      ),
    );
  }
}
