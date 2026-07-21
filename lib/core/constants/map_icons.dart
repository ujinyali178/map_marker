enum MapIconCategory {
  food,
  transport,
  accommodation,
  activities,
  services,
  nature,
  pointsOfInterest,
  danger,
  custom,
}

class MapIconKeys {
  MapIconKeys._();

  static const MapIconCategory defaultCategory = MapIconCategory.pointsOfInterest;
  static const String defaultKey = 'default';

  static const String restaurant = 'restaurant';
  static const String cafe = 'cafe';
  static const String bar = 'bar';
  static const String fastFood = 'fast_food';
  static const String grocery = 'grocery';

  static const String parking = 'parking';
  static const String busStop = 'bus_stop';
  static const String trainStation = 'train_station';
  static const String fuel = 'fuel';
  static const String chargingStation = 'charging_station';
  static const String bicycle = 'bicycle';

  static const String hotel = 'hotel';
  static const String hostel = 'hostel';
  static const String camping = 'camping';
  static const String apartment = 'apartment';

  static const String hiking = 'hiking';
  static const String swimming = 'swimming';
  static const String diving = 'diving';
  static const String fishing = 'fishing';
  static const String skiing = 'skiing';
  static const String playground = 'playground';
  static const String museum = 'museum';

  static const String hospital = 'hospital';
  static const String pharmacy = 'pharmacy';
  static const String police = 'police';
  static const String bank = 'bank';
  static const String toilet = 'toilet';
  static const String water = 'water';
  static const String shop = 'shop';

  static const String mountain = 'mountain';
  static const String forest = 'forest';
  static const String beach = 'beach';
  static const String lake = 'lake';
  static const String viewpoint = 'viewpoint';
  static const String tree = 'tree';

  static const String landmark = 'landmark';
  static const String monument = 'monument';
  static const String church = 'church';
  static const String temple = 'temple';

  static const String warning = 'warning';
  static const String construction = 'construction';
  static const String closed = 'closed';

  static const String customPin = 'custom_pin';
  static const String flag = 'flag';
  static const String star = 'star';

  static Map<MapIconCategory, List<String>> get categoryKeys => {
        MapIconCategory.food: [
          restaurant,
          cafe,
          bar,
          fastFood,
          grocery,
        ],
        MapIconCategory.transport: [
          parking,
          busStop,
          trainStation,
          fuel,
          chargingStation,
          bicycle,
        ],
        MapIconCategory.accommodation: [
          hotel,
          hostel,
          camping,
          apartment,
        ],
        MapIconCategory.activities: [
          hiking,
          swimming,
          diving,
          fishing,
          skiing,
          playground,
          museum,
        ],
        MapIconCategory.services: [
          hospital,
          pharmacy,
          police,
          bank,
          toilet,
          water,
          shop,
        ],
        MapIconCategory.nature: [
          mountain,
          forest,
          beach,
          lake,
          viewpoint,
          tree,
        ],
        MapIconCategory.pointsOfInterest: [
          landmark,
          monument,
          church,
          temple,
        ],
        MapIconCategory.danger: [
          warning,
          construction,
          closed,
        ],
        MapIconCategory.custom: [
          customPin,
          flag,
          star,
        ],
      };

  static String displayName(String key) {
    return key
        .replaceAllMapped(
          RegExp(r'([A-Z])'),
          (match) => ' ${match.group(1)}',
        )
        .replaceFirstMapped(
          RegExp(r'^.'),
          (match) => match.group(1)!.toUpperCase(),
        );
  }
}
