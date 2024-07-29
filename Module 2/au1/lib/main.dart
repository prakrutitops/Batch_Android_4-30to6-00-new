import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'homepage.dart';
import 'model/cart_model.dart';


void main() {
  runApp(
    ChangeNotifierProvider(
      create: (context) => CartModel(),
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.yellow)),
      debugShowCheckedModeBanner: false,
      home: Homepage(),
    );
  }
}
