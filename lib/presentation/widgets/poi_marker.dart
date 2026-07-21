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
    final theme = Theme.of(context);
    final effectiveColor = isSelected ? theme.colorScheme.primary : color;

    return GestureDetector(
      onTap: onTap,
      child: AnimatedContainer(
        duration: const Duration(milliseconds: 200),
        transform: Matrix4.translationValues(0, isSelected ? -8 : 0, 0),
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            if (isSelected)
              Container(
                padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 4),
                decoration: BoxDecoration(
                  color: theme.colorScheme.surface,
                  borderRadius: BorderRadius.circular(8),
                  boxShadow: [
                    BoxShadow(
                      color: Colors.black.withOpacity(0.15),
                      blurRadius: 6,
                      offset: const Offset(0, 2),
                    ),
                  ],
                ),
                child: Icon(icon, color: effectiveColor, size: 16),
              ),
            const SizedBox(height: 4),
            CustomPaint(
              size: const Size(36, 48),
              painter: _MarkerPainter(color: effectiveColor),
              child: SizedBox(
                width: 36,
                height: 48,
                child: Center(
                  child: Icon(
                    icon,
                    color: Colors.white,
                    size: isSelected ? 22 : 18,
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class _MarkerPainter extends CustomPainter {
  final Color color;

  _MarkerPainter({required this.color});

  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = color
      ..style = PaintingStyle.fill;

    final shadowPaint = Paint()
      ..color = Colors.black.withOpacity(0.25)
      ..maskFilter = const MaskFilter.blur(BlurStyle.normal, 3);

    final path = Path();
    path.moveTo(size.width / 2, size.height - 2);
    path.cubicTo(
      size.width * 0.15,
      size.height * 0.6,
      0,
      size.height * 0.35,
      0,
      size.height * 0.25,
    );
    path.cubicTo(
      0,
      size.height * 0.08,
      size.width * 0.15,
      0,
      size.width * 0.35,
      0,
    );
    path.lineTo(size.width * 0.65, 0);
    path.cubicTo(
      size.width * 0.85,
      0,
      size.width,
      size.height * 0.08,
      size.width,
      size.height * 0.25,
    );
    path.cubicTo(
      size.width,
      size.height * 0.35,
      size.width * 0.85,
      size.height * 0.6,
      size.width / 2,
      size.height - 2,
    );
    path.close();

    canvas.drawPath(path.shift(const Offset(0, 2)), shadowPaint);
    canvas.drawPath(path, paint);

    final circlePaint = Paint()
      ..color = Colors.white.withOpacity(0.3)
      ..style = PaintingStyle.fill;
    canvas.drawCircle(
      Offset(size.width / 2, size.height * 0.25),
      size.width * 0.2,
      circlePaint,
    );
  }

  @override
  bool shouldRepaint(covariant _MarkerPainter old) => old.color != color;
}
