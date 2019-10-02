class Responses {	static final  String[] list = {					"Somewhere nearby is Colossal Cave, where others have " +							// 1					"found fortunes in treasure and gold, though it is rumored " +					"that some who enter are never seen again.\nMagic is said " +					"to work in the cave.\nI will be your eyes and hands.\nDirect " +					"me with commands of 1 or 2 words.\nI should warn you that I " +					"look at only the first five letters of each word, so you'll " +					"have to enter 'Northeast' as 'ne' to distinguish it from " +					"'North'.\n(Should you get stuck, type 'help' for some " +					"general hints).\n",										"A little dwarf with a big knife blocks your way.",										// 2										"A little dwarf just walked around a corner, saw you, " +							// 3					"threw a little axe at you which missed, cursed, and ran away.",										"There is a threatening little dwarf in the room with you!",					// 4										"One sharp, nasty knife is thrown at you!",														// 5										"None of them hit you!",																							// 6										"One of them gets you!",																							// 7										"A hollow voice says 'Plugh'.",																				// 8										"There is no way to go that direction.",															// 9										"I am unsure how you are facing.\nUse compass points or " +						// 10					"nearby objects.",										"I don't know in from out here.\nUse compass points or name " +				// 11					"something in the general direction you want to go.",										"I don't know how to apply that word here.",													// 12										"I don't understand that!",																						// 13										"I'm game.\nWould you care to explain how?",													// 14										"Sorry, but I am not allowed to give more detail.\nI will " +					// 15					"repeat the long description of your location.",										"It is now pitch dark.\nIf you proceed you will likely fall " +				// 16					"into a pit.",					"If you prefer, simply type W rather than West.",											// 17										"Are you trying to catch the bird?",																	// 18										"The bird is frightened right now and you cannot catch " +						// 19					"it no matter what you try.\nPerhaps you might try later.",										"Are you trying to somehow deal with the snake?",											// 20										"You can't kill the snake, or drive it away, or avoid it, " +					// 21					"or anything like that.\nThere is a way to get by, but you " +					"don't have the necessary resources right now.",										"Do you really want to quit now?",																		// 22										"You fell into a pit and broke every bone in your body!",							// 23										"You are already carrying it!",																				// 24										"You can't be serious!",																							// 25										"The bird was unafraid when you entered, but as you approach " +			// 26					"it becomes disturbed and you cannot catch it.",										"You can catch the bird, but you cannot carry it.",										// 27										"There is nothing here with a lock!",																	// 28										"You aren't carrying it!",																						// 29										"The little bird attacks the green snake, and in an " +								// 30					"astounding flurry drives the snake away.",										"You have no keys!",																									// 31										"It has no lock.",																										// 32										"I don't know how to lock or unlock such a thing.",										// 33										"It was already locked.",																							// 34										"The grate is now locked.",																						// 35										"The grate is now unlocked.",																					// 36										"It was already unlocked.",																						// 37										"You have no source of light.",																				// 38										"Your lamp is now on.",																								// 39										"Your lamp is now off.",																							// 40										"There is no way to get past the bear to unlock the chain,_ " +				// 41					"which is probably just as well.",										"Nothing happens.",																										// 42										"Where?",																															// 43										"There is nothing here to attack.",																		// 44										"The little bird is now dead.\nIts body disappears.",									// 45										"Attacking the snake both doesn't work and is very dangerous.",				// 46										"You killed a little dwarf.",																					// 47										"You attack a little dwarf, but he dodges out of the way.",						// 48										"With what? Your bare hands?",																				// 49										"Good try, but that is an old worn-out magic word.",									// 50					"I know of places, actions, and things.\nMost of my vocabulary " +		// 51 (A)					"describes places and is used to move you there.\nTo move, try " +					"words like forest, building, downstream, enter, east, west, " +					"north, south, up or down.\nI know about a few special " +					"objects, like a black rod hidden in the cave.\nThese objects " +					"can be manipulated using some of the action words I know.\n" +					"Usually you will need to give both the object and action " +					"words (In either order), but sometimes I can infer the " +					"object from the verb alone.",/*										"I know of places, actions, and things.\nMost of my vocabulary " +		// 51 (B)					"describes places and is used to move you there.\nTo move, try " +		// Alternate text to 51 (A)					"words like forest, building, downstream, enter, east, west, " +			// May not be supported in code					"north, south, up or down.\nI know about a few special " +					"objects, like a black rod hidden in the cave.\nThese objects " +					"can be manipulated using some of the action words I know.\n" +					"Usually you will need to give both the object and action " +					"words (In either order), but sometimes I can infer the " +					"object from the verb alone.\nSome objects also imply verbs; " +					"in particular, 'inventory' implies 'take inventory', which " +					"causes me to give you a list of what you're carrying.\nThe " +					"objects have side effects; for instance, the rod scares the " +					"bird.\nUsually people having trouble moving just need " +					"to try a few more words.\nUsually people trying unsuccessfully " +					"to manipulate an object are attempting something beyond their " +					"(or my!) capabilities and should try a completely different " +					"tack.\nTo speed the game you can sometimes move long distances " +					"with a single word.\nFor example, 'building' usually gets you " +					"to the building from anywhere above ground except when lost " +					"in the forest.\nAlso, note that cave passages turn a lot, and " +					"that leaving a room to the north does not guarantee entering " +					"the next from the south.\n" +					"Good luck!",*/										"It misses!",																													// 52										"It gets you!",																												// 53										"ok.",																																// 54										"You can't unlock the keys.",																					// 55										"You have crawled around in some little holes and wound up " +				// 56					"back in the main passage.",										"I don't know where the cave is, but hereabouts no stream " +					// 57					"can run on the surface for very long.\nI would try the stream.",										"I need more detailed instructions to do that.",											// 58										"I can only tell you what you see as you move about and " +						// 59					"manipulate things.\nI cannot tell you where remote things are.",										"I don't know that word.",																						// 60										"What?",																															// 61										"Are you trying to get into the cave?",																// 62										"The grate is very solid and has a hardened steel lock.\nYou " +			// 63					"cannot enter without a key, and there are no keys nearby.\n" +					"I would recommend looking elsewhere for the keys.",										"The trees of the forest are large hardwood oak and maple, " +				// 64					"with an occasional grove of pine or spruce.\nThere is quite " +					"a bit of undergrowth, largely birch and ash saplings plus " +					"nondescript bushes of various sorts.\nThis time of year  " +					"visibility is quite restricted by all the leaves, but travel " +					"is quite easy if you detour around the spruce and berry " +					"bushes.",										"Welcome to ADVENTURE!\nWould you like instructions?",								// 65										"Digging without a shovel is quite impractical.\nEven with a " +			// 66					"shovel progress is unlikely.",										"Blasting requires dynamite.",																				// 67										"I'm as confused as you are.",																				// 68										"Mist is a white vapor, usually water.\nSeen from time to time " +		// 69					"in caverns.\nIt can be found anywhere but is frequently a " +					"sign of a deep pit leading down to water.",										"Your feet are now wet.",																							// 70										"I think I just lost my appetite.",																		// 71										"Thank you.\nIt was delicious!",																			// 72										"You have taken a drink from the stream.\nThe water tastes " +				// 73					"strongly of minerals, but is not unpleasant.\nIt is extremely " +					"cold.",										"The bottle of water is now empty.",																	// 74										"Rubbing the electric lamp is not particularly rewarding.\n" +				// 75					"Anyway, nothing exciting happens.",										"Peculiar.\nNothing unexpected happens.",															// 76										"Your bottle is empty and the ground is wet.",												// 77										"You can't pour that.",																								// 78										"Watch it!",																													// 79										"Which way?",																													// 80          // Later additions										"Oh dear, you seem to have gotten yourself killed.\nI might " +				// 81					"be able to help you out, but I've never really done this " +					"before.\nDo you want me to try to reincarnate you?",										"All right.\nBut don't blame me if something goes wr......\n" + 				// 82					 "--- POOF !! ---\n" +					"You are engulfed in a cloud of orange smoke.\nCoughing and " +					"gasping, you emerge from the smoke and find...",										"You clumsy oaf, you've done it again!\nI don't know how long " +			// 83					"I can keep this up.\nDo you want me to try reincarnating " +					"you again?",										"Okay, now where did i put my orange smoke?\n... > POOF! <\n" +					// 84					"Everything disappears in a dense cloud of orange smoke.",										"Now you've really done it!\nI'm out of orange smoke!\nYou " +				// 85					"don't expect me to do a decent reincarnation without any " +					"orange smoke, do you?",										"Okay, If you're so smart, do it yourself!\nI'm leaving!",						// 86										"Reserved",																														// 87										"Reserved",																														// 88										"Reserved",																														// 89										"Reserved",																														// 90										"Sorry, but I no longer seem to remember how it was you " +						// 91					"got here.",										"You can't carry anything more.\nYou'll have to drop something " +		// 92					"first.",										"You can't go through a locked steel grate!",													// 93										"I believe what you want is right here with you.",										// 94										"You don't fit through a two-inch slit!",															// 95										"I respectfully suggest you go across the bridge instead " +					// 96					"of jumping.",										"There is no way across the fissure.",																// 97										"You're not carrying anything.",																			// 98										"You are currently holding the following:",														// 99										"It's not hungry (It's merely pinin' for the Fjords).\nBesides " +		// 100					"You have no bird seed.",										"The snake has now devoured your bird.",															// 101										"There's nothing here it wants to eat (Except perhaps you).",					// 102										"You fool, Dwarves eat only coal!\nNow you've made " +								// 103					"him REALLY mad !!",					"You have nothing in which to carry it.",															// 104										"Your bottle is already full.",																				// 105										"There is nothing here with which to fill the bottle.",								// 106										"Your bottle is now full of water.",																	// 107										"Your bottle is now full of oil.",																		// 108										"You can't fill that.",																								// 109										"Don't be ridiculous!",																								// 110										"The door is extremely rusty and refuses to open.",										// 111										"The plant indignantly shakes the oil off its leaves and asks: " +		// 112					"'Water?'.",										"The hinges are quite thoroughly rusted now and won't budge.",				// 113										"The oil has freed up the hinges so that the door will now move, " +	// 114					"although it requires some effort.",										"The plant has exceptionally deep roots and cannot be pulled free.",	// 115										"The Dwarves' knives vanish as they strike the walls of the cave.",		// 116										"Something you're carrying won't fit through the tunnel with " +			// 117					"you.\nYou'd best take inventory and drop something.",										"You can't fit this five-foot clam through that little passage!",			// 118										"You can't fit this five foot oyster through that little passage!",		// 119										"I advise you to put down the clam before opening it. >STRAIN!<",			// 120										"I advise you to put down the oyster before opening it. " +						// 121					">WRENCH!<",										"You don't have anything strong enough to open the clam.",						// 122										"You don't have anything strong enough to open the oyster.",					// 123										"A glistening pearl falls out of the clam and rolls away.\n" +					// 124					"Goodness, this must really be an oyster.\n(I never was " +					"very good at identifying bivalves.)\nWhatever it is, " +					"it has now snapped shut again.",										"The oyster creaks open, revealing nothing but oyster inside.\n" +			// 125					"It promptly snaps shut again.",										"You have crawled around in some little holes and found your " +			// 126					"way blocked by a recent cave-in.\nYou are now back in the " +					"main passage.",										"There are faint rustling noises from the darkness behind " +					// 127					"you.",										"Out from the shadows behind you pounces a bearded pirate!\n" +				// 128					"'Har, har' he chortles, 'I'll just take all this booty and " +					"hide it away with me chest deep in the maze!'.\nHe snatches " +					"your treasure and vanishes into the gloom.",										"A sepulchral voice reverberating through the cave says: " +					// 129					"'Cave closing soon.\nAll adventurers exit immediately " +					"through main office.'",										"A mysterious recorded voice groans into life and announces: " +			// 130					"'This exit is closed.\nPlease leave via main office.'",										"It looks as though you're dead.\nWell, seeing as how it's so " +			// 131					"close to closing time anyway, I think we'll just call it a day.",										"The sepulchral voice entones, 'The cave is now closed.'\nAs " +			// 132					"the echoes fade, there is a blinding flash of light (and a " +					"small puff of orange smoke). . . .  \n" +					"As your eyes refocus you look around and find...",										"There is a loud explosion, and a twenty-foot hole appears in " +			// 133					"the far wall, burying the Dwarves in the rubble.\nYou march " +					"through the hole and find yourself in the main office, where " +					"a cheering band of friendly elves carry the conquering " +					"adventurer off into the sunset.",										"There is a loud explosion, and a twenty-foot hole appears in " +			// 134					"the far wall, burying the snakes in the rubble.\nA river of " +					"molten lava pours in through the hole, destroying " +					"everything in its path, including you!!",										"There is a loud explosion, and you are suddenly splashed across " +	// 135					"the walls of the room.",										"The resulting ruckus has awakened the Dwarves.\nThere are now " +		// 136					"several threatening little Dwarves in the room with you!\n" +					"Most of them throw knives at you!\nAll of them get you!",										"Oh, leave the poor unhappy bird alone.",															// 137										"I daresay whatever you want is around here somewhere.",							// 138										"I don't know the word 'stop'.\n Use 'quit' if you want to " +				// 139					"give up.",										"You can't get there from here.",																			// 140										"You are being followed by a very large, tame bear.",									// 141					"If you want to end your adventure early, say 'quit'.\nTo " +					// 142 (A)					"suspend you adventure such that you can continue later " +					"say 'suspend' (or 'pause' or 'save').\nTo see how well " +					"you're doing, say 'score'.\nTo get full credit for a " +					"treasure, you must have left it safely in the building, " +					"though you get partial credit just for locating it.\n" +					"You lose points for getting killed, or for quitting, " +					"though the former costs you more.\nThere are also points " +					"based on how much (If any) of the cave you've managed to " +					"explore;  in particular, there is a large bonus just for " +					"getting in (to distinguish the beginners from the rest of " +					"the pack.)",/*										"If you want to end your adventure early, say 'quit'.\nTo " +					// 142 (B)					"suspend you adventure such that you can continue later " +						// Alternate test 142 (A)					"say 'suspend' (or 'pause' or 'save').\nTo see how well " +						// May not be supported in code					"you're doing, say 'score'.\nTo get full credit for a " +					"treasure, you must have left it safely in the building, " +					"though you get partial credit just for locating it\n" +					"You lose points for getting killed, or for quitting, " +					"though the former costs you more.\nThere are also points " +					"based on how much (If any) of the cave you've managed to " +					"explore;  in particular, there is a large bonus just for " +					"getting in (to distinguish the beginners from the rest of " +					"the pack), and there are other ways to determine whether " +					"you've been through some of the more harrowing sections.\n" +					"If you think you've found all the treasures, just keep " +					"exploring for a while.\nIf nothing interesting happens, you " +					"haven't found them all yet.\nIf something interesting DOES " +					"happen, it means you're getting a bonus and have an " +					"opportunity to garner many more points in the master's " +					"section.\nI may occasionally offer hints in you seem to " +					"be having trouble.\nIf I do, I'll warn you in " +					"advance how much it will affect your score to accept the " +					"hints.\nFinally, to save paper, you may specify 'brief', " +					"which tells me never to repeat the full description of a place " +					"unless you explicitly ask me to.",*/					"Do you indeed wish to quit now?",																		// 143										"There is nothing here with which to fill the vase.",									// 144										"The sudden change in temperature has delicately shattered " +				// 145					"the vase.",										"It is beyond your power to do that.",																// 146										"I don't know how.",																									// 147										"It is too far up for you to reach.",																	// 148										"You killed a little Dwarf.\nThe body vanished in a cloud " +					// 149					"of greasy black smoke.",										"The shell is very strong and impervious to attack.",									// 150										"What's the matter, can't you read?  Now you'd best start " +					// 151					"over.",										"The axe bounces harmlessly off the dragon's thick scales.",					// 152										"The dragon looks rather nasty.\nYou'd best not try to get by.",			// 153										"The little bird attacks the green dragon, and in an " +							// 154					"astounding flurry gets burnt to a cinder.\nThe ashes blow away.",										"On what?",																														// 155										"Okay, from now on I'll only describe a place in full the " +					// 156					"first time you come to it.\nTo get the full description " +					"say 'look'.",										"Trolls are close relatives with the rocks and have skin as " +				// 157					"tough as that of a rhinoceros.\nThe troll fends off your " +					"blows effortlessly.",										"The troll deftly catches the axe, examines it carefully, " +					// 158					"and tosses it back, declaring, 'Good workmanship, " +					"but it's not valuable enough.'.",										"The troll catches your treasure and scurries away out of sight.",		// 159										"The troll refuses to let you cross.",																// 160										"There is no longer any way across the chasm.",												// 161										"Just as you reach the other side, the bridge buckles beneath " +			// 162					"the weight of the bear, which was still following you around.\n" +					"You scrabble desperately for support, but as the bridge  " +					"collapses you stumble back and fall into the chasm.",										"The bear lumbers toward the troll, who lets out a " +								// 163					"startled shriek and scurries away.\nThe bear soon gives " +					"up pursuit and wanders back.",										"The axe misses and lands near the bear where you can't get " +				// 164					"at it.",										"With what?  Your bare hands?  Agains HIS bear hands??",							// 165										"The bear is confused;  he only wants to be your friend.",						// 166										"For crying out loud, the poor thing is already dead!",								// 167										"The bear eagerly wolfs down your food, after which he seems " +			// 168					"to calm down considerably, and even becomes rather friendly.",										"The bear is still chained to the wall.",															// 169										"The chain is still locked.",																					// 170										"The chain is now unlocked.",																					// 171										"The chain is now locked.",																						// 172										"There is nothing here to which the chain can be locked.",						// 173										"There is nothing here to eat.",																			// 174										"Do you want the hint?",																							// 175										"Do you need help getting out of the maze?",													// 176										"You can make the passages look less alike by dropping things.",			// 177										"Are you trying to explore beyond the plover room?",									// 178										"There is a way to explore that region without having to " +					// 179					"worry about falling into a pit.\nNone of the objects " +					"available is immediately useful in descovering the secret.",										"Do you need help getting out of here?",															// 180										"Don't go west.",																											// 181										"Gluttony is not one of the Troll's vices.\nAvarice, however, is.",		// 182										"Your lamp is getting dim...\nYou'd best start wrapping this up, " +	// 183					"unless you can find some fresh batteries.\nI seem to recall " +					"there's a vending machine in the maze.\nBring some coins " +					"with you.",										"Your lamp has run out of power.",																		// 184										"There's not much point in wandering around out here, and you " +			// 185					"can't explore the cave without a lamp.\nSo let's just call " +					"it a day.",										"There are faint rustling noises from the darkness behind you.\n" +		// 186					"As you turn toward them, the beam of your lamp falls across a " +					"bearded pirate.\nHe is carrying a large chest.\n'Shiver me " +					"timbers!'  he cries, 'I've been spotted!\nI'd best hide " +					"meself off to the maze and hide me chest!'.\nWith that, " +					"he vanished into the gloom.",										"Your lamp is getting dim.\nYou'd best go back for  " +								// 187					"those batteries.",										"Your lamp is getting dim...\nI'm taking the liberty of replacing " +	// 188					"the batteries.",										"Your lamp is getting dim, and you're out of spare batteries.\n" +		// 189					"You'd best start wrapping this up.",										"I'm afraid the magazine is written in Dwarvish.",										// 190										"'This is not the maze where the pirate leaves his treasure " +				// 191					"chest.'",										"Hmm, this looks like a clue, which means it'll cost you 10 " +				// 192					"points to read it.\nShould I go ahead and read it anyway?",										"It says, 'There is something strange about this place, " +						// 193					"such that one of the words I've always known now has " +					"a new effect.'",										"It says the same thing it did before.",															// 194										"I'm afraid I don't understand.",																			// 195										"'Congratulations on bringing light into the dark-room!'",						// 196										"You strike the mirror a resounding blow, whereupon it " +						// 197					"shatters into a myriad tiny fragments.",										"You have taken the vase and hurled it delicately to the " +					// 198					"ground.",										"You prod the nearest Dwarf, who wakes up grumpily, takes " +					// 199					"one look at you, curses, and grabs for his axe.",										"Is this acceptable?",																								// 200										"There's no point in suspending a demonstration game."};							// 201}