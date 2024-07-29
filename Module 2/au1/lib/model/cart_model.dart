import 'package:flutter/material.dart';

import 'food_model.dart';

class CartModel extends ChangeNotifier {
  final List<Food> _cart = [];
  List<Food> get cart => _cart;

   
  void addToCart(Food food) {
    _cart.add(food);
    notifyListeners();
  }
}
