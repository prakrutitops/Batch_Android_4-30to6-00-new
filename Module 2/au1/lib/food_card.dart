import 'package:flutter/material.dart';
import 'package:flutter_rating_bar/flutter_rating_bar.dart';

class FoodCard extends StatefulWidget {
  final String image;
  final String name;
  final int rating;
  final double price;
  final Function()? onTap;

  const FoodCard({
    super.key,
    required this.image,
    required this.name,
    required this.price,
    required this.rating,
    required this.onTap,
  });

  @override
  State<FoodCard> createState() => _FoodCardState();
}

class _FoodCardState extends State<FoodCard> {
  @override
  Widget build(BuildContext context) {
    return Container(
        child: Card(
      shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          buildImage(context, widget.image),
          buildTitle(widget.name),
          buildRating(widget.rating),
          buildPriceInfo(widget.price, widget.onTap)
        ],
      ),
    ));
  }

  Widget buildImage(BuildContext context, String image) {
    return Container(
      height: MediaQuery.of(context).size.width / 2.5,
      child: ClipRRect(
        borderRadius: const BorderRadius.vertical(top: Radius.circular(12)),
        child: Image.asset(
          image,
          fit: BoxFit.cover,
        ),
      ),
    );
  }
}

Widget buildTitle(String name) {
  return Container(
    padding: const EdgeInsets.only(left: 8, right: 8),
    child: Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
          '$name',
          maxLines: 2,
          overflow: TextOverflow.ellipsis,
          //style: titleStyle,
        ),
      ],
    ),
  );
}

Widget buildRating(int rating) {
  return Padding(
    padding: const EdgeInsets.only(left: 4, right: 8),
    child: Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: <Widget>[
        RatingBar(
          initialRating: 5.0,
          direction: Axis.horizontal,
          itemCount: 5,
          itemSize: 14,
          unratedColor: Colors.black,
          itemPadding: EdgeInsets.only(right: 4.0),
          ignoreGestures: true,
          ratingWidget: RatingWidget(
              full: Icon(Icons.star),
              half: Icon(Icons.star_border),
              empty: Icon(Icons.star_border)),
          onRatingUpdate: (rating) {},
        ),
        Text('4.4'),
      ],
    ),
  );
}

Widget buildPriceInfo(double price, void Function()? onTap) {
  return Padding(
    padding: const EdgeInsets.only(left: 8, right: 8, bottom: 8),
    child: Row(
      mainAxisAlignment: MainAxisAlignment.spaceBetween,
      crossAxisAlignment: CrossAxisAlignment.center,
      children: <Widget>[
        Text(
          '\$${price}',
        ),
        Card(
          margin: EdgeInsets.only(right: 0),
          shape: RoundedRectangleBorder(),
          color: Colors.yellow,
          child: InkWell(
            onTap: onTap,
            splashColor: Colors.white70,
            customBorder:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(12)),
            child: Icon(Icons.add),
          ),
        )
      ],
    ),
  );
}
