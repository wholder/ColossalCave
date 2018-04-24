public class Map {

  static class Room {
    boolean   visited;
    String    longText, shortText;
    int       info;
    int[][]   moves;

    /**
     * Generates an oject that represents a location within Collossal Cave
     * @param longText Lengthy descriptive text
     * @param shortText abbrevited descriptive text
     * @param info bitmapped info about special features present, such as light, water, oil, or 2 for forced move
     * @param moves list of possible moves, or verb actions possible from this location.  Ths first entry in each
     *              subarray of 3 int values corresponds to an action value associated with a verb from the Vocabulary
     *              class, such as 44 for "north", etc.  The 2nd value indicates the destination if the action is
     *              taken and the 3rd value specifies an optional condition code that may be required for the action
     *              to be taken.  So, for example, the subarray "{ 44, 2, 0}" specifies than typing "West" or "W"
     *              will move the player to location #2, which is the "hill in road".  However, the comments for
     *              each subarray only show moves that result from cardinal compass commands (N, S, E, W, NE, etc.)
     *              A subarray like "{13, 4, 0}" responds to the command word "gully" and moves the user to loc #4.
     *              In addition, some destination values have additiona values added to them to encode other actions.
     */
    Room (String longText, String shortText, int info, int[][] moves) {
      this.longText = longText;
      this.shortText = shortText;
      this.info = info;
      this.moves = moves;
    }
  }

  static final Room[] cave = {
    new Room("You are standing at the end of a road before a small brick building.  " +      // Room 1
      "Around you is a forest.  A small stream flows out of the building and " +
      "down a gully.",
      "You're at end of road again.",
      5,
      new int[][] {
        {  2,   2,   0},
        { 44,   2,   0},       // W to loc 2 (hill in road)
        { 29,   2,   0},       // Up to loc 2 (hill in road)
        {  3,   3,   0},
        { 12,   3,   0},
        { 19,   3,   0},
        { 43,   3,   0},       // E to loc 3 (inside building)
        {  5,   4,   0},
        { 13,   4,   0},
        { 14,   4,   0},
        { 46,   4,   0},       // S to loc 4 (valley)
        { 30,   4,   0},       // Dn to loc 4 (valley)
        {  6,   5,   0},
        { 45,   5,   0},       // N to loc 5 (forest)
        { 43,   5,   0},       // E to loc 5 (forest)
        { 63,   8,   0}}),
    new Room("You have walked up a hill, still in the forest.  The road slopes back " +      // Room 2
      "down the other side of the hill.  There is a building in the distance.",
      "You're at hill in road.",
      1,
      new int[][] {
        {  2,   1,   0},
        { 12,   1,   0},
        {  7,   1,   0},
        { 43,   1,   0},       // E to loc 1 (end of road again)
        { 45,   1,   0},       // N to loc 1 (end of road again)
        { 30,   1,   0},       // Dn to loc 1 (end of road again)
        {  6,   5,   0},
        { 45,   5,   0},       // N to loc 5 (forest)
        { 46,   5,   0}}),     // S to loc 5 (forest)
    new Room("You are inside a building, a well house for a large spring.",                  // Room 3
      "You're inside building.",
      5,
      new int[][] {
        {  3,   1,   0},
        { 11,   1,   0},
        { 32,   1,   0},
        { 44,   1,   0},       // W to loc 1 (end of road again)
        { 62,  11,   0},
        { 65,  33,   0},
        {  5,  79,   0},
        { 14,  79,   0}}),
    new Room("You are in a valley in the forest beside a stream tumbling along a " +         // Room 4
      "rocky bed.",
      "You're in valley.",
      5,
      new int[][] {
        {  4,   1,   0},
        { 12,   1,   0},
        { 45,   1,   0},       // N to loc 1 (end of road again)
        {  6,   5,   0},
        { 43,   5,   0},       // E to loc 5 (forest)
        { 44,   5,   0},       // W to loc 5 (forest)
        { 29,   5,   0},       // Up to loc 5 (forest)
        {  5,   7,   0},
        { 46,   7,   0},       // S to loc 7 (slit in streambed)
        { 30,   7,   0},       // Dn to loc 7 (slit in streambed)
        { 63,   8,   0}}),
    new Room("You are in open forest, with a deep valley to one side.",                      // Room 5
      "You're in forest.",
      1,
      new int[][] {
        {  9,   4,   0},
        { 43,   4,   0},       // E to loc 4 (valley)
        { 30,   4,   0},       // Dn to loc 4 (valley)
        {  6,   5,  50},
        {  7,   5,  50},
        { 45,   5,  50},       // N to loc 5 (forest)
        {  6,   6,   0},
        { 44,   5,   0},       // W to loc 5 (forest)
        { 46,   5,   0}}),     // S to loc 5 (forest)
    new Room("You are in open forest near both a valley and a road.",                        // Room 6
      "You're in forest.",
      1,
      new int[][] {
        {  2,   1,   0},
        { 45,   1,   0},       // N to loc 1 (end of road again)
        {  9,   4,   0},
        { 43,   4,   0},       // E to loc 4 (valley)
        { 44,   4,   0},       // W to loc 4 (valley)
        { 30,   4,   0},       // Dn to loc 4 (valley)
        {  6,   5,   0},
        { 46,   5,   0}}),     // S to loc 5 (forest)
    new Room("At your feet all the water of the stream splashes into a 2-inch slit " +       // Room 7
      "in the rock.  Downstream the streambed is bare rock.",
      "You're at slit in streambed.",
      5,
      new int[][] {
        { 12,   1,   0},
        {  4,   4,   0},
        { 45,   4,   0},       // N to loc 4 (valley)
        {  6,   5,   0},
        { 43,   5,   0},       // E to loc 5 (forest)
        { 44,   5,   0},       // W to loc 5 (forest)
        {  5,   8,   0},
        { 15,   8,   0},
        { 16,   8,   0},
        { 46,   8,   0},       // S to loc 8 (outside grate)
        { 60, 595,   0},
        { 14, 595,   0},
        { 30, 595,   0}}),     // Dn to loc 595
    new Room("You are in a 20-foot depression floored with bare dirt.  Set into the " +      // Room 8
      "dirt is a strong steel grate mounted in concrete. A dry streambed " +
      "leads into the depression.",
      "You're outside grate.",
      1,
      new int[][] {
        {  6,   5,   0},
        { 43,   5,   0},       // E to loc 5 (forest)
        { 46,   5,   0},       // S to loc 5 (forest)
        { 44,   5,   0},       // W to loc 5 (forest)
        { 12,   1,   0},
        {  4,   7,   0},
        { 13,   7,   0},
        { 45,   7,   0},       // N to loc 7 (slit in streambed)
        {  3,   9, 303},
        { 19,   9, 303},
        { 30,   9, 303},       // Dn to loc 9 (below the grate)
        {  3, 593,   0}}),
    new Room("You are in a small chamber beneath a 3x3 steel grate to the surface.  " +      // Room 9
      "A low crawl over cobbles leads inward to the West.",
      "You're below the grate.",
      1,
      new int[][] {
        { 11,   8, 303},
        { 29,   8, 303},       // Up to loc 8 (outside grate)
        { 11, 593,   0},
        { 17,  10,   0},
        { 18,  10,   0},
        { 19,  10,   0},
        { 44,  10,   0},       // W to loc 10 (cobble crawl)
        { 31,  14,   0},
        { 51,  11,   0}}),
    new Room("You are crawling over cobbles in a low passage.  There is a dim light " +      // Room 10
      "at the east end of the passage.",
      "You're in cobble crawl.",
      1,
      new int[][] {
        { 11,   9,   0},
        { 20,   9,   0},
        { 21,   9,   0},
        { 43,   9,   0},       // E to loc 9 (below the grate)
        { 19,  11,   0},
        { 22,  11,   0},
        { 44,  11,   0},       // W to loc 11 (debris room)
        { 51,  11,   0},
        { 31,  14,   0}}),
    new Room("You are in a debris room filled with stuff washed in from the " +              // Room 11
      "surface.  A low wide passage with cobbles becomes plugged with mud " +
      "and debris here, but an awkward canyon leads upward and west.  A note " +
      "on the wall says: Magic Word 'XYZZY'",
      "You're in debris room.",
      0,
      new int[][] {
        { 63,   8, 303},
        { 64,   9,   0},
        { 17,  10,   0},
        { 18,  10,   0},
        { 23,  10,   0},
        { 24,  10,   0},
        { 43,  10,   0},       // E to loc 10 (cobble crawl)
        { 25,  12,   0},
        { 19,  12,   0},
        { 29,  12,   0},       // Up to loc 12 (awkward sloping east/west canyon)
        { 44,  12,   0},       // W to loc 12 (awkward sloping east/west canyon)
        { 62,   3,   0},
        { 31,  14,   0}}),
    new Room("You are in an awkward sloping east/west canyon.",                              // Room 12
      "You are in an awkward sloping east/west canyon.",
      0,
      new int[][] {
        { 63,   8, 303},
        { 64,   9,   0},
        { 30,  11,   0},       // Dn to loc 11 (debris room)
        { 43,  11,   0},       // E to loc 11 (debris room)
        { 51,  11,   0},
        { 19,  13,   0},
        { 29,  13,   0},       // Up to loc 13 (bird chamber)
        { 44,  13,   0},       // W to loc 13 (bird chamber)
        { 31,  14,   0}}),
    new Room("You are in a splendid chamber thirty feet high.  The walls are frozen " +      // Room 13
      "rivers of orange stone.  An awkward canyon and a good passage exit " +
      "from east and west sides of the chamber.",
      "You're in bird chamber.",
      0,
      new int[][] {
        { 63,   8, 303},
        { 64,   9,   0},
        { 51,  11,   0},
        { 25,  12,   0},
        { 43,  12,   0},       // E to loc 12 (awkward sloping east/west canyon)
        { 23,  14,   0},
        { 31,  14,   0},
        { 44,  14,   0}}),     // W to loc 14 (top of small pit)
    new Room("At your feet is a small pit breathing traces of white mist. An east " +        // Room 14
      "passage ends here except for a small crack leading on.",
      "You're at top of small pit.",
      0,
      new int[][] {
        { 63,   8, 303},
        { 64,   9,   0},
        { 51,  11,   0},
        { 23,  13,   0},
        { 43,  13,   0},       // E to loc 13 (bird chamber)
        { 30,  20, 150},       // Dn to loc 20 (bottom of the pit with a broken neck)
        { 31,  20, 150},
        { 34,  20, 150},
        { 30,  15,   0},       // Dn to loc 15 (hall of mists)
        { 33,  16,   0},
        { 44,  16,   0}}),     // W to loc 16 (The crack is far too small for you to follow)
    new Room("You are at one end of a vast hall stretching forward out of sight to " +       // Room 15
      "the west.  There are openings to either side. Nearby, a wide stone " +
      "staircase leads downward.  The hall is filled with wisps of white " +
      "mist swaying to and fro almost as if alive.  A cold wind blows up the " +
      "staircase. There is a passage at the top of a dome behind you.",
      "You're in hall of mists.",
      0,
      new int[][] {
        { 36,  18,   0},
        { 46,  18,   0},       // S to loc 18 (nugget of gold room)
        {  7,  17,   0},
        { 38,  17,   0},
        { 44,  17,   0},       // W to loc 17 (on east bank of fissure)
        { 10,  19,   0},
        { 30,  19,   0},       // Dn to loc 19 (hall of mt)
        { 45,  19,   0},       // N to loc 19 (hall of mt)
        { 29,  22, 150},       // Up to loc 22 (The dome is unclimbable)
        { 31,  22, 150},
        { 34,  22, 150},
        { 35,  22, 150},
        { 23,  22, 150},
        { 43,  22, 150},       // E to loc 22 (The dome is unclimbable)
        { 29,  14,   0},       // Up to loc 14 (top of small pit)
        { 55,  34,   0}}),
    new Room("The crack is far too small for you to follow.",                                // Room 16
      "The crack is far too small for you to follow.",
      2,
      new int[][] {
        {  1,  14,   0}}),
    new Room("You are on the east bank of a fissure slicing clear across the hall.  " +      // Room 17
      "The mist is quite thick here, and the fissure is too wide to jump.",
      "You're on east bank of fissure.",
      0,
      new int[][] {
        { 38,  15,   0},
        { 43,  15,   0},       // E to loc 15 (hall of mists)
        { 39, 596, 312},
        {  7,  21, 412},
        { 41, 597, 412},
        { 42, 597, 412},
        { 44, 597, 412},       // W to loc 597
        { 69, 597, 412},
        { 41,  27,   0}}),
    new Room("This is a low room with a crude note on the wall.  The note says:\n   " +      // Room 18
      "    You won't get it up the steps.",
      "You're in nugget of gold room.",
      0,
      new int[][] {
        { 38,  15,   0},
        { 11,  15,   0},
        { 45,  15,   0}}),     // N to loc 15 (hall of mists)
    new Room("You are in the hall of the mountain king, with passages off in all " +         // Room 19
      "directions.",
      "You're in hall of mt. king.",
      0,
      new int[][] {
        { 10,  15,   0},
        { 29,  15,   0},       // Up to loc 15 (hall of mists)
        { 43,  15,   0},       // E to loc 15 (hall of mists)
        { 45,  28, 311},       // N to loc 28 (low N/S passage at a hole in the floor)
        { 36,  28, 311},
        { 46,  29, 311},       // S to loc 29 (south side chamber)
        { 37,  29, 311},
        { 44,  30, 311},       // W to loc 30 (west side chamber of the hall of the mountain king)
        {  7,  30, 311},
        { 45,  32,   0},       // N to loc 32 (You can't get by the snake)
        { 49,  74,  35},       // SW to loc 74 (secret E/W canyon above tight canyon)
        { 49,  32, 211},       // SW to loc 32 (You can't get by the snake)
        { 66,  74,   0}}),
    new Room("You are at the bottom of the pit with a broken neck.",                         // Room 20
      "You are at the bottom of the pit with a broken neck.",
      2,
      new int[][] {
        {  1,   0,   0}}),
    new Room("You didn't make it.",                                                          // Room 21
      "You didn't make it.",
      2,
      new int[][] {
        {  1,   0,   0}}),
    new Room("The dome is unclimbable.",                                                     // Room 22
      "The dome is unclimbable.",
      2,
      new int[][] {
        {  1,  15,   0}}),
    new Room("You are at the west end of the twopit room.  There is a large hole in " +      // Room 23
      "the wall above the pit at this end of the room.",
      "You're at west end of twopit room.",
      0,
      new int[][] {
        { 43,  67,   0},       // E to loc 67 (east end of twopit room)
        { 42,  67,   0},
        { 44,  68,   0},       // W to loc 68 (slab room)
        { 61,  68,   0},
        { 30,  25,   0},       // Dn to loc 25 (west pit)
        { 31,  25,   0},
        { 52, 648,   0}}),
    new Room("You are that the bottom of the eastern pit in the twopit room.  There " +      // Room 24
      "is a small pool of oil in one corner of the pit.",
      "You're in east pit.",
      6,
      new int[][] {
        { 29,  67,   0},       // Up to loc 67 (east end of twopit room)
        { 11,  67,   0}}),
    new Room("You are at the bottom of the western pit in the towpit room. There is " +      // Room 25
      "a large hole in the wall about 25 feet above you.",
      "You're in west pit.",
      0,
      new int[][] {
        { 29,  23,   0},       // Up to loc 23 (west end of twopit room)
        { 11,  23,   0},
        { 56,  31, 724},
        { 56,  26,   0}}),
    new Room("You clamber up the plant and scurry through the hole at the top.",             // Room 26
      "You clamber up the plant and scurry through the hole at the top.",
      2,
      new int[][] {
        {  1,  88,   0}}),
    new Room("You are on the west side of the fissure in the hall of mists.",                // Room 27
      "You are on the west side of the fissure in the hall of mists.",
      0,
      new int[][] {
        { 39, 596, 312},
        {  7,  21, 412},
        { 41, 597, 412},
        { 42, 597, 412},
        { 43, 597, 412},       // E to loc 597
        { 69, 597, 412},
        { 41,  17,   0},
        { 45,  40,   0},       // N to loc 40 (low wide passage parallel to and north of the hall of mists)
        { 44,  41,   0}}),     // W to loc 41 (west end of hall of mists)
    new Room("You are in a low N/S passage at a hole in the floor.  The hole goes " +        // Room 28
      "down to an E/W passage.",
      "You are in a low N/S passage at a hole in the floor.  The hole goes " +
        "down to an E/W passage.",
      0,
      new int[][] {
        { 38,  19,   0},
        { 11,  19,   0},
        { 46,  19,   0},       // S to loc 19 (hall of mt)
        { 45,  33,   0},       // N to loc 33 ('Y2')
        { 55,  33,   0},
        { 30,  36,   0},       // Dn to loc 36 (dirty passage)
        { 52,  36,   0}}),
    new Room("You are in the south side chamber.",                                           // Room 29
      "You are in the south side chamber.",
      0,
      new int[][] {
        { 38,  19,   0},
        { 11,  19,   0},
        { 45,  19,   0}}),     // N to loc 19 (hall of mt)
    new Room("You are in the west side chamber of the hall of the mountain king.  A " +      // Room 30
      "passage continues west and up here.",
      "You are in the west side chamber of the hall of the mountain king.  A " +
        "passage continues west and up here.",
      0,
      new int[][] {
        { 38,  19,   0},
        { 11,  19,   0},
        { 43,  19,   0},       // E to loc 19 (hall of mt)
        { 44,  62,   0},       // W to loc 62 (crossover of a high N/S passage and a low E/W one)
        { 29,  62,   0}}),     // Up to loc 62 (crossover of a high N/S passage and a low E/W one)
    new Room(">$<",                                                                          // Room 31
      ">$<",
      2,
      new int[][] {
        {  1,  89, 524},
        {  1,  90,   0}}),
    new Room("You can't get by the snake.",                                                  // Room 32
      "You can't get by the snake.",
      2,
      new int[][] {
        {  1,  19,   0}}),
    new Room("You are in a large room, with a passage to the south, a passage to " +         // Room 33
      "the west, and a wall of broken rock to the east.  There is a large " +
      "'Y2' on a rock in the room's  center.",
      "You're at 'Y2'.",
      0,
      new int[][] {
        { 65,   3,   0},
        { 46,  28,   0},       // S to loc 28 (low N/S passage at a hole in the floor)
        { 43,  34,   0},       // E to loc 34 (jumble of rock)
        { 53,  34,   0},
        { 54,  34,   0},
        { 44,  35,   0},       // W to loc 35 (window on pit)
        { 71, 302, 159},
        { 71, 100,   0}}),
    new Room("You are in a jumble of rock, with cracks everywhere.",                         // Room 34
      "You are in a jumble of rock, with cracks everywhere.",
      0,
      new int[][] {
        { 30,  33,   0},       // Dn to loc 33 ('Y2')
        { 55,  33,   0},
        { 29,  15,   0}}),     // Up to loc 15 (hall of mists)
    new Room("You're at a low window overlooking a huge pit, which extends up out " +        // Room 35
      "of sight.  A floor is indistinctly visible over 50 feet below.  " +
      "Traces of white mist cover the floor of the pit, becoming thicker to " +
      "the right.  Marks in the dust around the window would seem to " +
      "indicate that someone has been here recently.  Directly across the " +
      "pit from you and 25 feet away there is a similar window looking into " +
      "a lighted room.  A shadowy figure can be seen there peering back at " +
      "you.",
      "You're at window on pit.",
      0,
      new int[][] {
        { 43,  33,   0},       // E to loc 33 ('Y2')
        { 55,  33,   0},
        { 39,  20,   0}}),
    new Room("You are in a dirty broken passage.  To the east is a crawl.  To the " +        // Room 36
      "west is a large passage.  Above you is another passage.",
      "You're in dirty passage.",
      0,
      new int[][] {
        { 43,  37,   0},       // E to loc 37 (brink of a small clean climbable pit)
        { 17,  37,   0},
        { 29,  28,   0},       // Up to loc 28 (low N/S passage at a hole in the floor)
        { 52,  28,   0},
        { 44,  39,   0},       // W to loc 39 (dusty rock room)
        { 70,  65,   0}}),
    new Room("You are on the brink of a small clean climbable pit.  A crawl leads " +        // Room 37
      "west.",
      "You are on the brink of a small clean climbable pit.  A crawl leads " +
        "west.",
      0,
      new int[][] {
        { 44,  36,   0},       // W to loc 36 (dirty passage)
        { 17,  36,   0},
        { 30,  38,   0},       // Dn to loc 38 (bottom of a small pit with a little stream)
        { 31,  38,   0},
        { 56,  38,   0}}),
    new Room("You are in the bottom of a small pit with a little stream, which " +           // Room 38
      "enters and exits through tiny slits.",
      "You are in the bottom of a small pit with a little stream, which " +
        "enters and exits through tiny slits.",
      4,
      new int[][] {
        { 56,  37,   0},
        { 29,  37,   0},       // Up to loc 37 (brink of a small clean climbable pit)
        { 11,  37,   0},
        { 60, 595,   0},
        { 14, 595,   0},
        { 30, 595,   0},       // Dn to loc 595
        {  4, 595,   0},
        {  5, 595,   0}}),
    new Room("You are in a large room full of dusty rocks.  There is a big hole in " +       // Room 39
      "the floor.  There are cracks everywhere, and a passage leading east.",
      "You're in dusty rock room.",
      0,
      new int[][] {
        { 43,  36,   0},       // E to loc 36 (dirty passage)
        { 23,  36,   0},
        { 30,  64,   0},       // Dn to loc 64 (complex junction)
        { 52,  64,   0},
        { 58,  64,   0},
        { 70,  65,   0}}),
    new Room("You have crawled through a very low wide passage parallel to and " +           // Room 40
      "north of the hall of mists.",
      "You have crawled through a very low wide passage parallel to and " +
        "north of the hall of mists.",
      2,
      new int[][] {
        {  1,  41,   0}}),
    new Room("You are at the west end of hall of mists.  A low wide crawl continues " +      // Room 41
      "west and another goes north.  To the south is a little passage 6 feet " +
      "off the floor.",
      "You're at west end of hall of mists.",
      0,
      new int[][] {
        { 46,  42,   0},       // S to loc 42 (maze of twisty little passages)
        { 29,  42,   0},       // Up to loc 42 (maze of twisty little passages)
        { 23,  42,   0},
        { 56,  42,   0},
        { 43,  27,   0},       // E to loc 27 (west side of the fissure in the hall of mists)
        { 45,  59,   0},       // N to loc 59 (low wide passage paralled to and north of the hall of mists)
        { 44,  60,   0},       // W to loc 60 (east end of long hall)
        { 17,  60,   0}}),
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 42
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 29,  41,   0},       // Up to loc 41 (west end of hall of mists)
        { 45,  42,   0},       // N to loc 42 (maze of twisty little passages)
        { 43,  43,   0},       // E to loc 43 (maze of twisty little passages)
        { 46,  45,   0},       // S to loc 45 (maze of twisty little passages)
        { 44,  80,   0}}),     // W to loc 80 (maze of twisty little passages)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 43
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 44,  42,   0},       // W to loc 42 (maze of twisty little passages)
        { 46,  44,   0},       // S to loc 44 (maze of twisty little passages)
        { 43,  45,   0}}),     // E to loc 45 (maze of twisty little passages)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 44
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 43,  43,   0},       // E to loc 43 (maze of twisty little passages)
        { 30,  48,   0},       // Dn to loc 48 (Dead end)
        { 46,  50,   0},       // S to loc 50 (maze of twisty little passages)
        { 45,  82,   0}}),     // N to loc 82 (Dead end)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 45
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 44,  42,   0},       // W to loc 42 (maze of twisty little passages)
        { 45,  43,   0},       // N to loc 43 (maze of twisty little passages)
        { 43,  46,   0},       // E to loc 46 (Dead end)
        { 46,  47,   0},       // S to loc 47 (Dead end)
        { 29,  87,   0},       // Up to loc 87 (maze of twisty little passages)
        { 30,  87,   0}}),     // Dn to loc 87 (maze of twisty little passages)
    new Room("Dead end",                                                                     // Room 46
      "Dead end.",
      8,
      new int[][] {
        { 44,  45,   0},       // W to loc 45 (maze of twisty little passages)
        { 11,  45,   0}}),
    new Room("Dead end",                                                                     // Room 47
      "Dead end.",
      8,
      new int[][] {
        { 43,  45,   0},       // E to loc 45 (maze of twisty little passages)
        { 11,  45,   0}}),
    new Room("Dead end",                                                                     // Room 48
      "Dead end.",
      8,
      new int[][] {
        { 29,  44,   0},       // Up to loc 44 (maze of twisty little passages)
        { 11,  44,   0}}),
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 49
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 43,  50,   0},       // E to loc 50 (maze of twisty little passages)
        { 44,  51,   0}}),     // W to loc 51 (maze of twisty little passages)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 50
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 43,  44,   0},       // E to loc 44 (maze of twisty little passages)
        { 44,  49,   0},       // W to loc 49 (maze of twisty little passages)
        { 30,  51,   0},       // Dn to loc 51 (maze of twisty little passages)
        { 46,  52,   0}}),     // S to loc 52 (maze of twisty little passages)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 51
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 44,  49,   0},       // W to loc 49 (maze of twisty little passages)
        { 29,  50,   0},       // Up to loc 50 (maze of twisty little passages)
        { 43,  52,   0},       // E to loc 52 (maze of twisty little passages)
        { 46,  53,   0}}),     // S to loc 53 (maze of twisty little passages)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 52
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 44,  50,   0},       // W to loc 50 (maze of twisty little passages)
        { 43,  51,   0},       // E to loc 51 (maze of twisty little passages)
        { 46,  52,   0},       // S to loc 52 (maze of twisty little passages)
        { 29,  53,   0},       // Up to loc 53 (maze of twisty little passages)
        { 45,  55,   0},       // N to loc 55 (maze of twisty little passages)
        { 30,  86,   0}}),     // Dn to loc 86 (Dead end)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 53
      "You are in a maze of twisty little passages, all alike.",
      8,
      new int[][] {
        { 44,  51,   0},       // W to loc 51 (maze of twisty little passages)
        { 45,  52,   0},       // N to loc 52 (maze of twisty little passages)
        { 46,  54,   0}}),     // S to loc 54 (Dead end)
    new Room("Dead end",                                                                     // Room 54
      "Dead end.",
      0,
      new int[][] {
        { 44,  53,   0},       // W to loc 53 (maze of twisty little passages)
        { 11,  53,   0}}),
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 55
      "You are in a maze of twisty little passages, all alike.",
      8,
      new int[][] {
        { 44,  52,   0},       // W to loc 52 (maze of twisty little passages)
        { 45,  55,   0},       // N to loc 55 (maze of twisty little passages)
        { 30,  56,   0},       // Dn to loc 56 (Dead end)
        { 43,  57,   0}}),     // E to loc 57 (brink of pit)
    new Room("Dead end",                                                                     // Room 56
      "Dead end.",
      0,
      new int[][] {
        { 29,  55,   0},       // Up to loc 55 (maze of twisty little passages)
        { 11,  55,   0}}),
    new Room("You are on the brink of a thirty foot pit with a massive orange " +            // Room 57
      "column down one wall.  You could climb down here but you could not " +
      "get back up.  The maze continues at this level.",
      "You're at brink of pit.",
      8,
      new int[][] {
        { 30,  13,   0},       // Dn to loc 13 (bird chamber)
        { 56,  13,   0},
        { 44,  55,   0},       // W to loc 55 (maze of twisty little passages)
        { 46,  58,   0},       // S to loc 58 (Dead end)
        { 45,  83,   0},       // N to loc 83 (maze of twisty little passages)
        { 43,  84,   0}}),     // E to loc 84 (maze of twisty little passages)
    new Room("Dead end",                                                                     // Room 58
      "Dead end.",
      0,
      new int[][] {
        { 43,  57,   0},       // E to loc 57 (brink of pit)
        { 11,  57,   0}}),
    new Room("You have crawled through a very low wide passage paralled to and " +           // Room 59
      "north of the hall of mists.",
      "You have crawled through a very low wide passage paralled to and " +
        "north of the hall of mists.",
      2,
      new int[][] {
        {  1,  27,   0}}),
    new Room("You are at the east end of a very long hall apparently without side " +        // Room 60
      "chambers.  To the east a low wide crawl slants up.  To the north a " +
      "round two foot hole slants down.",
      "You're at east end of long hall.",
      0,
      new int[][] {
        { 43,  41,   0},       // E to loc 41 (west end of hall of mists)
        { 29,  41,   0},       // Up to loc 41 (west end of hall of mists)
        { 17,  41,   0},
        { 44,  61,   0},       // W to loc 61 (west end of long hall)
        { 45,  62,   0},       // N to loc 62 (crossover of a high N/S passage and a low E/W one)
        { 30,  62,   0},       // Dn to loc 62 (crossover of a high N/S passage and a low E/W one)
        { 52,  62,   0}}),
    new Room("You are at the west end of a very long featureless hall. The hall " +          // Room 61
      "joins up with a narrow north/south passage.",
      "You're at west end of long hall.",
      0,
      new int[][] {
        { 43,  60,   0},       // E to loc 60 (east end of long hall)
        { 45,  62,   0},       // N to loc 62 (crossover of a high N/S passage and a low E/W one)
        { 46, 107, 100}}),     // S to loc 107 (maze of twisty little passages)
    new Room("You are at a crossover of a high N/S passage and a low E/W one.",              // Room 62
      "You are at a crossover of a high N/S passage and a low E/W one.",
      0,
      new int[][] {
        { 44,  60,   0},       // W to loc 60 (east end of long hall)
        { 45,  63,   0},       // N to loc 63 (Dead end)
        { 43,  30,   0},       // E to loc 30 (west side chamber of the hall of the mountain king)
        { 46,  61,   0}}),     // S to loc 61 (west end of long hall)
    new Room("Dead end",                                                                     // Room 63
      "Dead end.",
      0,
      new int[][] {
        { 46,  62,   0},       // S to loc 62 (crossover of a high N/S passage and a low E/W one)
        { 11,  62,   0}}),
    new Room("You are at a complex junction.  A low hands and knees passage from " +         // Room 64
      "the north joins a higher crawl from the east to make a walking " +
      "passage going west.  There is also a large room above.  The air is " +
      "damp here.",
      "You're at complex junction.",
      0,
      new int[][] {
        { 29,  39,   0},       // Up to loc 39 (dusty rock room)
        { 56,  39,   0},
        { 59,  39,   0},
        { 44,  65,   0},       // W to loc 65 (You are in bedquilt)
        { 70,  65,   0},
        { 45, 103,   0},       // N to loc 103 (shell room)
        { 74, 103,   0},
        { 43, 106,   0}}),     // E to loc 106 (anteroom)
    new Room("You are in bedquilt, a long east/west passage with holes everywhere.  " +      // Room 65
      "To explore at random select north, south, up or down.",
      "You are in bedquilt, a long east/west passage with holes everywhere.  " +
        "To explore at random select north, south, up or down.",
      0,
      new int[][] {
        { 43,  64,   0},       // E to loc 64 (complex junction)
        { 44,  66,   0},       // W to loc 66 (swiss cheese room)
        { 46, 556,  80},       // S to loc 556
        { 61,  68,   0},
        { 29, 556,  80},       // Up to loc 556
        { 29,  70,  50},       // Up to loc 70 (secret N/S canyon above a sizable passage)
        { 29,  39,   0},       // Up to loc 39 (dusty rock room)
        { 45, 556,  60},       // N to loc 556
        { 45,  72,  75},       // N to loc 72 (large low room)
        { 45,  71,   0},       // N to loc 71 (junction of three secret canyons)
        { 30, 556,  80},       // Dn to loc 556
        { 30, 106,   0}}),     // Dn to loc 106 (anteroom)
    new Room("You are in a room whose walls resemble swiss cheese.   Obvious " +             // Room 66
      "passages go west, east, ne, and nw.  Part of the room is occupied by " +
      "a large bedrock block.",
      "You're in swiss cheese room.",
      0,
      new int[][] {
        { 47,  65,   0},       // NE to loc 65 (You are in bedquilt)
        { 44,  67,   0},       // W to loc 67 (east end of twopit room)
        { 46, 556,  80},       // S to loc 556
        { 25,  77,   0},
        { 43,  96,   0},       // E to loc 96 (soft room)
        { 50, 556,  50},       // NW to loc 556
        { 72,  97,   0}}),
    new Room("You are at the east end of the twopit room.  The floor here is " +             // Room 67
      "littered with thin rock slabs, which make it easy to descend the " +
      "pits.  There is a path here bypassing the pits to connect passages " +
      "from east and west. There are holes all over, but the only bit one is " +
      "on the wall directly over the west pit where you can't get at it.",
      "You're at east end of twopit room.",
      0,
      new int[][] {
        { 43,  66,   0},       // E to loc 66 (swiss cheese room)
        { 44,  23,   0},       // W to loc 23 (west end of twopit room)
        { 42,  23,   0},
        { 30,  24,   0},       // Dn to loc 24 (east pit)
        { 31,  24,   0}}),
    new Room("You are in a large low circular chamber whose floor is an immense " +          // Room 68
      "slab fallen from the ceiling (slab room). East and west there once " +
      "were large passages, but they are now filled with boulders.  Low " +
      "small passages go north and south, and the south one quickly bends " +
      "west around the boulders.",
      "You're in slab room.",
      0,
      new int[][] {
        { 46,  23,   0},       // S to loc 23 (west end of twopit room)
        { 29,  69,   0},       // Up to loc 69 (secret N/S canyon above a large room)
        { 56,  69,   0},
        { 45,  65,   0}}),     // N to loc 65 (You are in bedquilt)
    new Room("You are in a secret N/S canyon above a large room.",                           // Room 69
      "You are in a secret N/S canyon above a large room.",
      0,
      new int[][] {
        { 30,  68,   0},       // Dn to loc 68 (slab room)
        { 61,  68,   0},
        { 46, 120, 331},       // S to loc 120 (secret canyon which exits to the north and east)
        { 46, 119,   0},       // S to loc 119 (secret canyon which exits to the north and east)
        { 45, 109,   0},       // N to loc 109 (mirror canyon)
        { 75, 113,   0}}),
    new Room("You are in a secret N/S canyon above a sizable passage.",                      // Room 70
      "You are in a secret N/S canyon above a sizable passage.",
      0,
      new int[][] {
        { 45,  71,   0},       // N to loc 71 (junction of three secret canyons)
        { 30,  65,   0},       // Dn to loc 65 (You are in bedquilt)
        { 23,  65,   0},
        { 46, 111,   0}}),     // S to loc 111 (top of stalactite)
    new Room("You are in a secret canyon at a junction of three canyons, bearing " +         // Room 71
      "north, south and se.  The north one is as tall as the other two " +
      "combined.",
      "You're at junction of three secret canyons.",
      0,
      new int[][] {
        { 48,  65,   0},       // SE to loc 65 (You are in bedquilt)
        { 46,  70,   0},       // S to loc 70 (secret N/S canyon above a sizable passage)
        { 45, 110,   0}}),     // N to loc 110 (window on pit)
    new Room("You are in a large low room.  Crawls lead north, se, and sw.",                 // Room 72
      "You are in a large low room.  Crawls lead north, se, and sw.",
      0,
      new int[][] {
        { 70,  65,   0},
        { 49, 118,   0},       // SW to loc 118 (sloping corridor)
        { 45,  73,   0},       // N to loc 73 (Dead end crawl)
        { 48,  97,   0},       // SE to loc 97 (oriental room)
        { 72,  97,   0}}),
    new Room("Dead end crawl.",                                                              // Room 73
      "Dead end crawl.",
      0,
      new int[][] {
        { 46,  72,   0},       // S to loc 72 (large low room)
        { 17,  72,   0},
        { 11,  72,   0}}),
    new Room("You are in a secret canyon which here runs E/W.  It crosses over a " +         // Room 74
      "very tight canyon 15 feet below.  If you go down you may not be able " +
      "to get back up.",
      "You're at secret E/W canyon above tight canyon.",
      0,
      new int[][] {
        { 43,  19,   0},       // E to loc 19 (hall of mt)
        { 44, 120, 331},       // W to loc 120 (secret canyon which exits to the north and east)
        { 44, 121,   0},       // W to loc 121 (secret canyon which exits to the north and east)
        { 30,  75,   0}}),     // Dn to loc 75 (wide place in a very tight N/S canyon)
    new Room("You are at a wide place in a very tight N/S canyon.",                          // Room 75
      "You are at a wide place in a very tight N/S canyon.",
      0,
      new int[][] {
        { 46,  76,   0},       // S to loc 76 (The canyon here becomes too tight to go further south)
        { 45,  77,   0}}),     // N to loc 77 (tall E/W canyon)
    new Room("The canyon here becomes too tight to go further south.",                       // Room 76
      "The canyon here becomes too tight to go further south.",
      0,
      new int[][] {
        { 45,  75,   0}}),     // N to loc 75 (wide place in a very tight N/S canyon)
    new Room("You are in a tall E/W canyon.  A low tight crawl goes 3 feet north " +         // Room 77
      "and seems to open up.",
      "You are in a tall E/W canyon.  A low tight crawl goes 3 feet north " +
        "and seems to open up.",
      0,
      new int[][] {
        { 43,  75,   0},       // E to loc 75 (wide place in a very tight N/S canyon)
        { 44,  78,   0},       // W to loc 78 (The canyon runs into a mass of boulders -- dead end)
        { 45,  66,   0},       // N to loc 66 (swiss cheese room)
        { 17,  66,   0}}),
    new Room("The canyon runs into a mass of boulders -- dead end.",                         // Room 78
      "The canyon runs into a mass of boulders -- dead end.",
      0,
      new int[][] {
        { 46,  77,   0}}),     // S to loc 77 (tall E/W canyon)
    new Room("The stream flows out through a pair of 1 foot diameter sewer pipes.  " +       // Room 79
      "It would be advisable to use the exit.",
      "The stream flows out through a pair of 1 foot diameter sewer pipes.  " +
        "It would be advisable to use the exit.",
      2,
      new int[][] {
        {  1,   3,   0}}),
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 80
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 45,  42,   0},       // N to loc 42 (maze of twisty little passages)
        { 44,  80,   0},       // W to loc 80 (maze of twisty little passages)
        { 46,  80,   0},       // S to loc 80 (maze of twisty little passages)
        { 43,  81,   0}}),     // E to loc 81 (Dead end)
    new Room("Dead end.",                                                                    // Room 81
      "Dead end.",
      0,
      new int[][] {
        { 44,  80,   0},       // W to loc 80 (maze of twisty little passages)
        { 11,  80,   0}}),
    new Room("Dead end.",                                                                    // Room 82
      "Dead end.",
      8,
      new int[][] {
        { 46,  44,   0},       // S to loc 44 (maze of twisty little passages)
        { 11,  44,   0}}),
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 83
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 46,  57,   0},       // S to loc 57 (brink of pit)
        { 43,  84,   0},       // E to loc 84 (maze of twisty little passages)
        { 44,  85,   0}}),     // W to loc 85 (Dead end)
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 84
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 45,  57,   0},       // N to loc 57 (brink of pit)
        { 44,  83,   0},       // W to loc 83 (maze of twisty little passages)
        { 50, 114,   0}}),     // NW to loc 114 (Dead end)
    new Room("Dead end.",                                                                    // Room 85
      "Dead end.",
      8,
      new int[][] {
        { 43,  83,   0},       // E to loc 83 (maze of twisty little passages)
        { 11,  83,   0}}),
    new Room("Dead end.",                                                                    // Room 86
      "Dead end.",
      8,
      new int[][] {
        { 29,  52,   0},       // Up to loc 52 (maze of twisty little passages)
        { 11,  52,   0}}),
    new Room("You are in a maze of twisty little passages, all alike.",                      // Room 87
      "You are in a maze of twisty little passages, all alike.",
      0,
      new int[][] {
        { 29,  45,   0},       // Up to loc 45 (maze of twisty little passages)
        { 30,  45,   0}}),     // Dn to loc 45 (maze of twisty little passages)
    new Room("You are in a long, narrow corridor stretching out of sight to the " +          // Room 88
      "west.  At the eastern end is a hole through which you can see a " +
      "profusion of leaves,",
      "You're in narrow corridor.",
      0,
      new int[][] {
        { 30,  25,   0},       // Dn to loc 25 (west pit)
        { 56,  25,   0},
        { 43,  25,   0},       // E to loc 25 (west pit)
        { 39,  20,   0},
        { 44,  92,   0},       // W to loc 92 (giant room)
        { 27,  92,   0}}),
    new Room("There is nothing here to climb.  Use 'up' or 'out' to leave the pit.",         // Room 89
      "There is nothing here to climb.  Use 'up' or 'out' to leave the pit.",
      2,
      new int[][] {
        {  1,  25,   0}}),
    new Room("You have climbed up the plant and out of the pit.",                            // Room 90
      "You have climbed up the plant and out of the pit.",
      2,
      new int[][] {
        {  1,  23,   0}}),
    new Room("You are at the top of a steep incline above a large room. You could " +        // Room 91
      "climb down here, but you would not be able to climb up.  There is a " +
      "passage leading back to the north.",
      "You're at steep incline above large room.",
      0,
      new int[][] {
        { 45,  95,   0},       // N to loc 95 (cavern with waterfall)
        { 73,  95,   0},
        { 23,  95,   0},
        { 30,  72,   0},       // Dn to loc 72 (large low room)
        { 56,  72,   0}}),
    new Room("You are in the giant room.  The ceiling is too high up for your lamp " +       // Room 92
      "to show it.  Cavernous passages lead east, north, and south.  On the " +
      "west wall is scrawled the inscription:\n              'Fee Fie Foe " +
      "Foo'       {sic}",
      "You're in giant room.",
      0,
      new int[][] {
        { 46,  88,   0},       // S to loc 88 (narrow corridor)
        { 43,  93,   0},       // E to loc 93 (The passage here is blocked by a recent cave-in)
        { 45,  94,   0}}),     // N to loc 94 (immense north/south passage)
    new Room("The passage here is blocked by a recent cave-in.",                             // Room 93
      "The passage here is blocked by a recent cave-in.",
      0,
      new int[][] {
        { 46,  92,   0},       // S to loc 92 (giant room)
        { 27,  92,   0},
        { 11,  92,   0}}),
    new Room("You are at one end of an immense north/south passage.",                        // Room 94
      "You are at one end of an immense north/south passage.",
      0,
      new int[][] {
        { 46,  92,   0},       // S to loc 92 (giant room)
        { 27,  92,   0},
        { 23,  92,   0},
        { 45,  95, 309},       // N to loc 95 (cavern with waterfall)
        {  3,  95, 309},
        { 73,  95, 309},
        { 45, 611,   0}}),     // N to loc 611
    new Room("You are in a magnificent cavern with a rushing stream, which cascades " +      // Room 95
      "over a sparkling waterfall into a roaring whirlpool which disappears " +
      "through a hole in the floor.  Passages exit to the south and west.",
      "You're in cavern with waterfall.",
      4,
      new int[][] {
        { 46,  94,   0},       // S to loc 94 (immense north/south passage)
        { 11,  94,   0},
        { 27,  92,   0},
        { 44,  91,   0}}),     // W to loc 91 (steep incline above large room)
    new Room("You are in the soft room.  The walls are covered with heavy curtains, " +      // Room 96
      "the floor with a thick pile carpet. Moss covers the ceiling.",
      "You're in soft room.",
      0,
      new int[][] {
        { 44,  66,   0},       // W to loc 66 (swiss cheese room)
        { 11,  66,   0}}),
    new Room("This is the oriental room.  Ancient oriental cave drawings cover the " +       // Room 97
      "walls.  A gently sloping passage leads upward to the north, another " +
      "passage leads se, and a hands and knees crawl leads west.",
      "You're in oriental room.",
      0,
      new int[][] {
        { 48,  66,   0},       // SE to loc 66 (swiss cheese room)
        { 44,  72,   0},       // W to loc 72 (large low room)
        { 17,  72,   0},
        { 29,  98,   0},       // Up to loc 98 (misty cavern)
        { 45,  98,   0},       // N to loc 98 (misty cavern)
        { 73,  98,   0}}),
    new Room("You are following a wide path around the outer edge of a large " +             // Room 98
      "cavern.  Far below, through a heavy white mist, strange splashing " +
      "noises can be heard.  The mist rises up through a fissure in the " +
      "ceiling.  The path exits to the south and west.",
      "You're in misty cavern.",
      0,
      new int[][] {
        { 46,  97,   0},       // S to loc 97 (oriental room)
        { 72,  97,   0},
        { 44,  99,   0}}),     // W to loc 99 (alcove)
    new Room("You are in an alcove.  A small nw path seems to widen after a short " +        // Room 99
      "distance.  An extremely tight tunnel leads east.  It looks like a " +
      "very tight squeeze.  An eerie light can be seen at the other end.",
      "You're in alcove.",
      0,
      new int[][] {
        { 50,  98,   0},       // NW to loc 98 (misty cavern)
        { 73,  98,   0},
        { 43, 301,   0},       // E to loc 301
        { 23, 301,   0},
        { 43, 100,   0}}),     // E to loc 100 (plover room)
    new Room("You're in a small chamber lit by an eerie green light.  An extremely " +       // Room 100
      "narrow tunnel exits to the west.  A dark corridor leads ne.",
      "You're in plover room.",
      1,
      new int[][] {
        { 44, 301,   0},       // W to loc 301
        { 23, 301,   0},
        { 11, 301,   0},
        { 44,  99,   0},       // W to loc 99 (alcove)
        { 71, 302, 159},
        { 71,  33,   0},
        { 47, 101,   0},       // NE to loc 101 (dark-room)
        { 22, 101,   0}}),
    new Room("You're in the dark-room.  A corridor leading south is the only exit.",         // Room 101
      "You're in dark-room.",
      0,
      new int[][] {
        { 46, 100,   0},       // S to loc 100 (plover room)
        { 71, 100,   0},
        { 11, 100,   0}}),
    new Room("You are in an arched hall.  A coral passage once continued up and " +          // Room 102
      "east from here, but is now blocked by debris.  The air smells of sea " +
      "water.",
      "You're in arched hall.",
      0,
      new int[][] {
        { 30, 103,   0},       // Dn to loc 103 (shell room)
        { 74, 103,   0},
        { 11, 103,   0}}),
    new Room("You're in a large room carved out of sedimentary rock. The floor and " +       // Room 103
      "walls are littered with bits of shells imbedded in the stone.  A " +
      "shallow passage proceeds downward, and a somewhat steeper one leads " +
      "up.  A low hands and knees passage enters from the south.",
      "You're in shell room.",
      0,
      new int[][] {
        { 29, 102,   0},       // Up to loc 102 (arched hall)
        { 38, 102,   0},
        { 30, 104,   0},       // Dn to loc 104 (long sloping corridor with ragged sharp walls)
        { 46, 618, 114},       // S to loc 618
        { 46, 619, 115},       // S to loc 619
        { 46,  64,   0}}),     // S to loc 64 (complex junction)
    new Room("You are in a long sloping corridor with ragged sharp walls.",                  // Room 104
      "You are in a long sloping corridor with ragged sharp walls.",
      0,
      new int[][] {
        { 29, 103,   0},       // Up to loc 103 (shell room)
        { 74, 103,   0},
        { 30, 105,   0}}),     // Dn to loc 105 (cul-de-sac about eight feet across)
    new Room("You are in a cul-de-sac about eight feet across.",                             // Room 105
      "You are in a cul-de-sac about eight feet across.",
      0,
      new int[][] {
        { 29, 104,   0},       // Up to loc 104 (long sloping corridor with ragged sharp walls)
        { 11, 104,   0},
        { 74, 103,   0}}),
    new Room("You are in an anteroom leading to a large passage to the east.  Small " +      // Room 106
      "passages go west and up.  The remnants of recent digging are evident. " +
      " A sign in midair here says:\n       'Cave under construction beyond " +
      "this point.'\n              'Proceed at your own risk.'\n             " +
      "'Witt construction company'",
      "You're in anteroom.",
      0,
      new int[][] {
        { 29,  64,   0},       // Up to loc 64 (complex junction)
        { 44,  65,   0},       // W to loc 65 (You are in bedquilt)
        { 43, 108,   0}}),     // E to loc 108 (Witt's end)
    new Room("You are in a maze of twisty little passages, all different.",                  // Room 107
      "You are in a maze of twisty little passages, all different.",
      0,
      new int[][] {
        { 46, 131,   0},       // S to loc 131 (maze of twisting little passages)
        { 49, 132,   0},       // SW to loc 132 (little maze of twisty passages)
        { 47, 133,   0},       // NE to loc 133 (twisting maze of little passages)
        { 48, 134,   0},       // SE to loc 134 (twisting little maze of passages)
        { 29, 135,   0},       // Up to loc 135 (twisty little maze of passages)
        { 50, 136,   0},       // NW to loc 136 (twisty maze of little passages)
        { 43, 137,   0},       // E to loc 137 (little twisty maze of passages)
        { 44, 138,   0},       // W to loc 138 (maze of little twisting passages)
        { 45, 139,   0},       // N to loc 139
        { 30,  61,   0}}),     // Dn to loc 61 (west end of long hall)
    new Room("You are at Witt's end.  Passages lead off in ALL directions.",                 // Room 108
      "You're at Witt's end.",
      0,
      new int[][] {
        { 43, 556,  95},       // E to loc 556
        { 45, 556,  95},       // N to loc 556
        { 46, 556,  95},       // S to loc 556
        { 47, 556,  95},       // NE to loc 556
        { 48, 556,  95},       // SE to loc 556
        { 49, 556,  95},       // SW to loc 556
        { 50, 556,  95},       // NW to loc 556
        { 29, 556,  95},       // Up to loc 556
        { 30, 556,  95},       // Dn to loc 556
        { 43, 106,   0},       // E to loc 106 (anteroom)
        { 44, 626,   0}}),     // W to loc 626
    new Room("You are in a north/south canyon about 25 feet across.  The floor is " +        // Room 109
      "covered by white mist seeping in from the north. The walls extend " +
      "upward for well over 100 feet.  Suspended from some unseen point far " +
      "above you, an enormous two- sided mirror is hanging paralled to and " +
      "midway between the canyon walls.  (The mirror is obviously provided " +
      "for the use of the dwarves, who as you know, are extremely vain.)  A " +
      "small window can be seen in either wall, some fifty feet up.",
      "You're in mirror canyon.",
      0,
      new int[][] {
        { 46,  69,   0},       // S to loc 69 (secret N/S canyon above a large room)
        { 45, 113,   0},       // N to loc 113 (reservoir)
        { 75, 113,   0}}),
    new Room("You're at a low window overlooking a huge pit, which extends up out " +        // Room 110
      "of sight.  A floor is indistinctly visible over 50 feet below.  " +
      "Traces of white mist cover the floor of the pit, becoming thicker to " +
      "the left.  Marks in the dust around the window would seem to indicate " +
      "that someone has been here recently.  Directly across the pit from " +
      "you and 25 feet away there is a similar window looking into a lighted " +
      "room.  A shadowy figure can be seen there peering back at you.",
      "You're at window on pit.",
      0,
      new int[][] {
        { 44,  71,   0},       // W to loc 71 (junction of three secret canyons)
        { 39,  20,   0}}),
    new Room("A large stalactite extends from the roof and almost reaches the floor " +      // Room 111
      "below.  You could climb down it, and jump from it to the floor, but " +
      "having done so you would be unable to reach it to climb back up.",
      "You're at top of stalactite.",
      0,
      new int[][] {
        { 45,  70,   0},       // N to loc 70 (secret N/S canyon above a sizable passage)
        { 30,  50,  40},       // Dn to loc 50 (maze of twisty little passages)
        { 39,  50,  40},
        { 56,  50,  40},
        { 30,  53,  50},       // Dn to loc 53 (maze of twisty little passages)
        { 30,  45,   0}}),     // Dn to loc 45 (maze of twisty little passages)
    new Room("You are in a little maze of twisting passages, all different.",                // Room 112
      "You are in a little maze of twisting passages, all different.",
      0,
      new int[][] {
        { 49, 131,   0},       // SW to loc 131 (maze of twisting little passages)
        { 45, 132,   0},       // N to loc 132 (little maze of twisty passages)
        { 43, 133,   0},       // E to loc 133 (twisting maze of little passages)
        { 50, 134,   0},       // NW to loc 134 (twisting little maze of passages)
        { 48, 135,   0},       // SE to loc 135 (twisty little maze of passages)
        { 47, 136,   0},       // NE to loc 136 (twisty maze of little passages)
        { 44, 137,   0},       // W to loc 137 (little twisty maze of passages)
        { 30, 138,   0},       // Dn to loc 138 (maze of little twisting passages)
        { 29, 139,   0},       // Up to loc 139
        { 46, 140,   0}}),     // S to loc 140
    new Room("You are at the edge of a large underground reservoir.  An opaque " +           // Room 113
      "cloud of white mist fills the room and rises rapidly upward.  The " +
      "lake is fed by a stream which tumbles out of a hole in the wall about " +
      "10 feet overhead and splashes noisily into the water somewhere within " +
      "the mist. The only passage goes back toward the south.",
      "You're at reservoir.",
      4,
      new int[][] {
        { 46, 109,   0},       // S to loc 109 (mirror canyon)
        { 11, 109,   0},
        {109, 109,   0}}),
    new Room("Dead end.",                                                                    // Room 114
      "Dead end.",
      0,
      new int[][] {
        { 48,  84,   0}}),     // SE to loc 84 (maze of twisty little passages)
    new Room("You are at the northeast end of an immense room, even larger than the " +      // Room 115
      "giant room.  It appears to be a repository for the 'adventure' " +
      "program.  Massive torches far overhead bathe the room with smoky " +
      "yellow light.  Scattered about you can be seen a pile of bottles (all " +
      "of them empty), a nursery of young beanstalks murmuring quietly, a " +
      "bed of oysters, a bundle of black rods with rusty stars on their " +
      "ends, and a collection of brass lanterns.  Off to one side a great " +
      "many Dwarves are sleeping on the floor, snoring loudly.  A sign " +
      "nearby reads:\n        'Do NOT disturb the Dwarves!'\nAn immense " +
      "mirror is hanging against one wall, and stretches to the other end of " +
      "the room, where various other sundry objects can be glimpsed dimly in " +
      "the distance.",
      "You're at ne end of repository.",
      1,
      new int[][] {
        { 49, 116,   0}}),     // SW to loc 116 (sw end of repository)
    new Room("You are at the southwest end of the repository.  To one side is a pit " +      // Room 116
      "full of fierce green snakes.  On the other side is a row of small " +
      "wicker cages, each of which contains a little sulking bird.  In one " +
      "corner is a bundle of black rods with rusty marks on their ends.  A " +
      "large number of velvet pillows are scattered about on the floor. A " +
      "vast mirror stretches off to the northeast.  At your feet is a large " +
      "steel grate, next to which is a sign which reads:\n     'Treasure " +
      "vault.  Keys in main office.'",
      "You're at sw end of repository.",
      1,
      new int[][] {
        { 47, 115,   0},       // NE to loc 115 (ne end of repository)
        { 30, 593,   0}}),     // Dn to loc 593
    new Room("You are on one side of a large deep chasm.  A heavy white mist rising " +      // Room 117
      "up from below obscures all view of the far side.  A sw path leads " +
      "away from the chasm into a winding corridor.",
      "You're on sw side of chasm.",
      0,
      new int[][] {
        { 49, 118,   0},       // SW to loc 118 (sloping corridor)
        { 41, 660, 233},
        { 42, 660, 233},
        { 69, 660, 233},
        { 47, 660, 233},       // NE to loc 660
        { 41, 661, 332},
        { 41, 303,   0},
        { 39,  21, 332},
        { 39, 596,   0}}),
    new Room("You are in a long winding corridor sloping out of sight in both " +            // Room 118
      "directions.",
      "You're in sloping corridor.",
      0,
      new int[][] {
        { 30,  72,   0},       // Dn to loc 72 (large low room)
        { 29, 117,   0}}),     // Up to loc 117 (on sw side of chasm)
    new Room("You are in a secret canyon which exits to the north and east.",                // Room 119
      "You are in a secret canyon which exits to the north and east.",
      0,
      new int[][] {
        { 45,  69,   0},       // N to loc 69 (secret N/S canyon above a large room)
        { 11,  69,   0},
        { 43, 653,   0},       // E to loc 653
        {307,  65,   0}}),
    new Room("You are in a secret canyon which exits to the north and east.",                // Room 120
      "You are in a secret canyon which exits to the north and east.",
      0,
      new int[][] {
        { 45,  69,   0},       // N to loc 69 (secret N/S canyon above a large room)
        { 43,  74,   0}}),     // E to loc 74 (secret E/W canyon above tight canyon)
    new Room("You are in a secret canyon which exits to the north and east.",                // Room 121
      "You are in a secret canyon which exits to the north and east.",
      0,
      new int[][] {
        { 43,  74,   0},       // E to loc 74 (secret E/W canyon above tight canyon)
        { 11,  74,   0},
        { 45, 653,   0},       // N to loc 653
        {  7, 653,   0}}),
    new Room("You are on the far side of the chasm.  A ne path leads away from the " +       // Room 122
      "chasm on this side.",
      "You're on ne side of chasm.",
      8,
      new int[][] {
        { 47, 123,   0},       // NE to loc 123 (corridor)
        { 41, 660, 233},
        { 42, 660, 233},
        { 69, 660, 233},
        { 49, 660, 233},       // SW to loc 660
        { 41, 303,   0},
        { 39, 596,   0},
        { 77, 124,   0},
        { 28, 126,   0},
        { 40, 129,   0}}),
    new Room("You're in a long east/west corridor.  A faint rumbling noise can be " +        // Room 123
      "heard in the distance.",
      "You're in corridor.",
      8,
      new int[][] {
        { 44, 122,   0},       // W to loc 122 (on ne side of chasm)
        { 43, 124,   0},       // E to loc 124 (fork in path)
        { 77, 124,   0},
        { 28, 126,   0},
        { 40, 129,   0}}),
    new Room("The path forks here.  The left fork leads northeast.  A dull rumbling " +      // Room 124
      "seems to get louder in that direction.  The right fork leads " +
      "southeast down a gentle slope.  The main corridor enters from the " +
      "west.",
      "You're at fork in path.",
      8,
      new int[][] {
        { 44, 123,   0},       // W to loc 123 (corridor)
        { 47, 125,   0},       // NE to loc 125 (junction with warm walls)
        { 36, 125,   0},
        { 48, 128,   0},       // SE to loc 128 (limestone passage)
        { 37, 128,   0},
        { 30, 128,   0},       // Dn to loc 128 (limestone passage)
        { 28, 126,   0},
        { 40, 129,   0}}),
    new Room("The walls are quite warm here.  From the north can be heard a steady " +       // Room 125
      "roar, so loud that the entire cave seems to be trembling.  Another " +
      "passage leads south, and a low crawl goes east.",
      "You're at junction with warm walls.",
      8,
      new int[][] {
        { 46, 124,   0},       // S to loc 124 (fork in path)
        { 77, 124,   0},
        { 45, 126,   0},       // N to loc 126 (breath-taking view)
        { 28, 126,   0},
        { 43, 127,   0},       // E to loc 127 (chamber of boulders)
        { 17, 127,   0}}),
    new Room("You are on the edge of a breath-taking view.  Far below you is an " +          // Room 126
      "active volcano, from which great gouts of molten lava come surging " +
      "out, cascading back down into the depths. The glowing rock fills the " +
      "farthest reaches of the cavern with a blood-red glare, giving " +
      "everything an eerie, macabre appearance.  The air is filled with " +
      "flickering sparks of ash and a heavy smell of brimstone.  The walls " +
      "are hot to the touch, and the thundering of the volcano drowns out " +
      "all other sounds.  A dark, foreboding passage exits to the south.",
      "You're at breath-taking view.",
      8,
      new int[][] {
        { 46, 125,   0},       // S to loc 125 (junction with warm walls)
        { 23, 125,   0},
        { 11, 125,   0},
        { 77, 124,   0},
        { 30, 610,   0},       // Dn to loc 610
        { 39, 610,   0}}),
    new Room("You are in a small chamber filled with large boulders. The walls are " +       // Room 127
      "very warm, causing the air in the room to be almost stifling from the " +
      "heat.  The only exit is a crawl heading west, through which is coming " +
      "a low rumbling.",
      "You're in chamber of boulders.",
      8,
      new int[][] {
        { 44, 125,   0},       // W to loc 125 (junction with warm walls)
        { 11, 125,   0},
        { 17, 125,   0},
        { 77, 124,   0},
        { 28, 126,   0}}),
    new Room("You are walking along a gently sloping north/south passage lined with " +      // Room 128
      "oddly shaped limestone formations.",
      "You're in limestone passage.",
      8,
      new int[][] {
        { 45, 124,   0},       // N to loc 124 (fork in path)
        { 29, 124,   0},       // Up to loc 124 (fork in path)
        { 77, 124,   0},
        { 46, 129,   0},       // S to loc 129 (front of barren room)
        { 30, 129,   0},       // Dn to loc 129 (front of barren room)
        { 40, 129,   0},
        { 28, 126,   0}}),
    new Room("You are standing at the entrance to a large, barren room.  A sign " +          // Room 129
      "posted above the entrance reads:\n      'Caution!  Bear in room!'",
      "You're in front of barren room.",
      8,
      new int[][] {
        { 44, 128,   0},       // W to loc 128 (limestone passage)
        { 29, 128,   0},       // Up to loc 128 (limestone passage)
        { 77, 124,   0},
        { 43, 130,   0},       // E to loc 130 (barren room)
        { 19, 130,   0},
        { 40, 130,   0},
        {  3, 130,   0},
        { 28, 126,   0}}),
    new Room("You are inside a barren room.  The center of the room is completely " +        // Room 130
      "empty except for some dust.  Marks in the dust lead away toward the " +
      "far end of the room. The only exit is the way you came in.",
      "You're in barren room.",
      8,
      new int[][] {
        { 44, 129,   0},       // W to loc 129 (front of barren room)
        { 77, 124,   0},
        { 28, 126,   0}}),
    new Room("You are in a maze of twisting little passages, all different.",                // Room 131
      "You are in a maze of twisting little passages, all different.",
      0,
      new int[][] {
        { 44, 107,   0},       // W to loc 107 (maze of twisty little passages)
        { 48, 132,   0},       // SE to loc 132 (little maze of twisty passages)
        { 50, 133,   0},       // NW to loc 133 (twisting maze of little passages)
        { 49, 134,   0},       // SW to loc 134 (twisting little maze of passages)
        { 47, 135,   0},       // NE to loc 135 (twisty little maze of passages)
        { 29, 136,   0},       // Up to loc 136 (twisty maze of little passages)
        { 30, 137,   0},       // Dn to loc 137 (little twisty maze of passages)
        { 45, 138,   0},       // N to loc 138 (maze of little twisting passages)
        { 46, 139,   0},       // S to loc 139
        { 43, 112,   0}}),     // E to loc 112 (little maze of twisting passages)
    new Room("You are in a little maze of twisty passages, all different.",                  // Room 132
      "You are in a little maze of twisty passages, all different.",
      0,
      new int[][] {
        { 50, 107,   0},       // NW to loc 107 (maze of twisty little passages)
        { 29, 131,   0},       // Up to loc 131 (maze of twisting little passages)
        { 45, 133,   0},       // N to loc 133 (twisting maze of little passages)
        { 46, 134,   0},       // S to loc 134 (twisting little maze of passages)
        { 44, 135,   0},       // W to loc 135 (twisty little maze of passages)
        { 49, 136,   0},       // SW to loc 136 (twisty maze of little passages)
        { 47, 137,   0},       // NE to loc 137 (little twisty maze of passages)
        { 43, 138,   0},       // E to loc 138 (maze of little twisting passages)
        { 30, 139,   0},       // Dn to loc 139
        { 48, 112,   0}}),     // SE to loc 112 (little maze of twisting passages)
    new Room("You are in a twisting maze of little passages, all different.",                // Room 133
      "You are in a twisting maze of little passages, all different.",
      0,
      new int[][] {
        { 29, 107,   0},       // Up to loc 107 (maze of twisty little passages)
        { 30, 131,   0},       // Dn to loc 131 (maze of twisting little passages)
        { 44, 132,   0},       // W to loc 132 (little maze of twisty passages)
        { 47, 134,   0},       // NE to loc 134 (twisting little maze of passages)
        { 49, 135,   0},       // SW to loc 135 (twisty little maze of passages)
        { 43, 136,   0},       // E to loc 136 (twisty maze of little passages)
        { 45, 137,   0},       // N to loc 137 (little twisty maze of passages)
        { 50, 138,   0},       // NW to loc 138 (maze of little twisting passages)
        { 48, 139,   0},       // SE to loc 139
        { 46, 112,   0}}),     // S to loc 112 (little maze of twisting passages)
    new Room("You are in a twisting little maze of passages, all different.",                // Room 134
      "You are in a twisting little maze of passages, all different.",
      0,
      new int[][] {
        { 47, 107,   0},       // NE to loc 107 (maze of twisty little passages)
        { 45, 131,   0},       // N to loc 131 (maze of twisting little passages)
        { 50, 132,   0},       // NW to loc 132 (little maze of twisty passages)
        { 48, 133,   0},       // SE to loc 133 (twisting maze of little passages)
        { 43, 135,   0},       // E to loc 135 (twisty little maze of passages)
        { 30, 136,   0},       // Dn to loc 136 (twisty maze of little passages)
        { 46, 137,   0},       // S to loc 137 (little twisty maze of passages)
        { 29, 138,   0},       // Up to loc 138 (maze of little twisting passages)
        { 44, 139,   0},       // W to loc 139
        { 49, 112,   0}}),     // SW to loc 112 (little maze of twisting passages)
    new Room("You are in a twisty little maze of passages, all different.",                  // Room 135
      "You are in a twisty little maze of passages, all different.",
      0,
      new int[][] {
        { 45, 107,   0},       // N to loc 107 (maze of twisty little passages)
        { 48, 131,   0},       // SE to loc 131 (maze of twisting little passages)
        { 30, 132,   0},       // Dn to loc 132 (little maze of twisty passages)
        { 46, 133,   0},       // S to loc 133 (twisting maze of little passages)
        { 43, 134,   0},       // E to loc 134 (twisting little maze of passages)
        { 44, 136,   0},       // W to loc 136 (twisty maze of little passages)
        { 49, 137,   0},       // SW to loc 137 (little twisty maze of passages)
        { 47, 138,   0},       // NE to loc 138 (maze of little twisting passages)
        { 50, 139,   0},       // NW to loc 139
        { 29, 112,   0}}),     // Up to loc 112 (little maze of twisting passages)
    new Room("You are in a twisty maze of little passages, all different.",                  // Room 136
      "You are in a twisty maze of little passages, all different.",
      0,
      new int[][] {
        { 43, 107,   0},       // E to loc 107 (maze of twisty little passages)
        { 44, 131,   0},       // W to loc 131 (maze of twisting little passages)
        { 29, 132,   0},       // Up to loc 132 (little maze of twisty passages)
        { 49, 133,   0},       // SW to loc 133 (twisting maze of little passages)
        { 30, 134,   0},       // Dn to loc 134 (twisting little maze of passages)
        { 46, 135,   0},       // S to loc 135 (twisty little maze of passages)
        { 50, 137,   0},       // NW to loc 137 (little twisty maze of passages)
        { 48, 138,   0},       // SE to loc 138 (maze of little twisting passages)
        { 47, 139,   0},       // NE to loc 139
        { 45, 112,   0}}),     // N to loc 112 (little maze of twisting passages)
    new Room("You are in a little twisty maze of passages, all different.",                  // Room 137
      "You are in a little twisty maze of passages, all different.",
      0,
      new int[][] {
        { 48, 107,   0},       // SE to loc 107 (maze of twisty little passages)
        { 47, 131,   0},       // NE to loc 131 (maze of twisting little passages)
        { 46, 132,   0},       // S to loc 132 (little maze of twisty passages)
        { 30, 133,   0},       // Dn to loc 133 (twisting maze of little passages)
        { 29, 134,   0},       // Up to loc 134 (twisting little maze of passages)
        { 50, 135,   0},       // NW to loc 135 (twisty little maze of passages)
        { 45, 136,   0},       // N to loc 136 (twisty maze of little passages)
        { 49, 138,   0},       // SW to loc 138 (maze of little twisting passages)
        { 43, 139,   0},       // E to loc 139
        { 44, 112,   0}}),     // W to loc 112 (little maze of twisting passages)
    new Room("You are in a maze of little twisting passages, all different.",                // Room 138
      "You are in a maze of little twisting passages, all different.",
      0,
      new int[][] {
        { 30, 107,   0},       // Dn to loc 107 (maze of twisty little passages)
        { 43, 131,   0},       // E to loc 131 (maze of twisting little passages)
        { 47, 132,   0},       // NE to loc 132 (little maze of twisty passages)
        { 29, 133,   0},       // Up to loc 133 (twisting maze of little passages)
        { 44, 134,   0},       // W to loc 134 (twisting little maze of passages)
        { 45, 135,   0},       // N to loc 135 (twisty little maze of passages)
        { 46, 136,   0},       // S to loc 136 (twisty maze of little passages)
        { 48, 137,   0},       // SE to loc 137 (little twisty maze of passages)
        { 49, 139,   0},       // SW to loc 139
        { 50, 112,   0}}),     // NW to loc 112 (little maze of twisting passages)
    new Room("You are in a maze of little twisty passages, all different.",                  // Room 139
      "You are in a maze of little twisty passages, all different.",
      0,
      new int[][] {
        { 49, 107,   0},       // SW to loc 107 (maze of twisty little passages)
        { 50, 131,   0},       // NW to loc 131 (maze of twisting little passages)
        { 43, 132,   0},       // E to loc 132 (little maze of twisty passages)
        { 44, 133,   0},       // W to loc 133 (twisting maze of little passages)
        { 45, 134,   0},       // N to loc 134 (twisting little maze of passages)
        { 30, 135,   0},       // Dn to loc 135 (twisty little maze of passages)
        { 48, 136,   0},       // SE to loc 136 (twisty maze of little passages)
        { 29, 137,   0},       // Up to loc 137 (little twisty maze of passages)
        { 46, 138,   0},       // S to loc 138 (maze of little twisting passages)
        { 47, 112,   0}}),     // NE to loc 112 (little maze of twisting passages)
    new Room("Dead end.",                                                                    // Room 140
      "Dead end.",
      0,
      new int[][] {
        { 45, 112,   0},       // N to loc 112 (little maze of twisting passages)
        { 11, 112,   0}}),
  };
}
