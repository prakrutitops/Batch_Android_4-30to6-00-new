import 'package:au1/pages/cart_pages.dart';
import 'package:au1/pages/show_food_list.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'model/cart_model.dart';


class Homepage extends StatefulWidget {
  const Homepage({super.key});

  @override
  State<Homepage> createState() => _HomepageState();
}

class _HomepageState extends State<Homepage> {
  @override
  Widget build(BuildContext context) {
    return Consumer<CartModel>(
      builder: (context, value, child) {
        //set index for bottom nav
        int index = 0;
        List<Widget> pages = [
          ShowFoodList(
            value: value,
          ),
          CartPage()
        ];
        //change bottomnav index
        void onBottonNavChange(int index) {
          setState(() {
            index = index;
          });
        }

        return Scaffold(
          bottomNavigationBar: BottomNavigationBar(
            currentIndex: index,
            onTap: onBottonNavChange,
            items: const [
              BottomNavigationBarItem(icon: Icon(Icons.menu), label: "Menu"),
              BottomNavigationBarItem(
                  icon: Icon(Icons.shopping_cart), label: "Cart"),
            ],
          ),
          body: pages[index],
          floatingActionButton: Visibility(
              visible: value.cart.isNotEmpty,
              child: FloatingActionButton(
                onPressed: () {
                  showModalBottomSheet(
                    context: context,
                    builder: (context) {
                      return Padding(
                        padding: const EdgeInsets.all(16.0),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.stretch,
                          children: [
                            const Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text(
                                  'Your Order',
                                  style: TextStyle(
                                      fontSize: 24,
                                      fontWeight: FontWeight.bold),
                                ),
                                Icon(
                                  Icons.food_bank,
                                  size: 34,
                                )
                              ],
                            ),
                            Expanded(
                              child: ListView.builder(
                                itemCount: value.cart.length,
                                itemBuilder: (context, index) {
                                  return ListTile(
                                    title: Text(
                                      value.cart[index].name,
                                      style: const TextStyle(
                                          fontSize: 16,
                                          fontWeight: FontWeight.bold),
                                    ),
                                    subtitle:
                                        Text(value.cart[index].discription),
                                    trailing: Text(
                                      '\$${value.cart[index].price}',
                                      style: const TextStyle(fontSize: 16),
                                    ),
                                  );
                                },
                              ),
                            ),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                const Text(
                                  "Total",
                                  style: TextStyle(
                                      fontSize: 18, color: Colors.grey),
                                ),
                                Text(
                                  '\$${value.cart.fold(0, (previousValue, element) => previousValue + element.price.toInt())}',
                                  style: const TextStyle(
                                      fontSize: 18,
                                      fontWeight: FontWeight.bold),
                                )
                              ],
                            ),
                            ElevatedButton(
                              onPressed: () {
                                Navigator.push(
                                    context,
                                    MaterialPageRoute(
                                      builder: (context) => CartPage(),
                                    ));
                              },
                              child: const Text('Add to Cart'),
                            ),
                          ],
                        ),
                      );
                    },
                  );
                },
                child: const Icon(Icons.shopping_bag),
              )),
        );
      },
    );
  }
}
