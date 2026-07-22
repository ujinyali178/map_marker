import 'package:flutter/material.dart';

class PoiMarker extends StatelessWidget {
  final Color color;
  final IconData icon;
  final bool isSelected;
  final VoidCallback? onTap;

  const PoiMarker({
    super.key,
    this.color = Colors.red,
    this.icon = Icons.location_on,
    this.isSelected = false,
    this.onTap,
  });

  @override
  Widget build(BuildContext context) {
    final effectiveColor = isSelected ? Colors.white : color;
    final bgColor = isSelected ? color : color;

    return GestureDetector(
      onTap: onTap,
      child: AnimatedContainer(
        duration: const Duration(milliseconds: 200),
        transform: Matrix4.translationValues(0, isSelected ? -6 : 0, 0),
        child: Icon(
          icon,
          color: bgColor,
          size: isSelected ? 42 : 36,
        ),
      ),
    );
  }
}
