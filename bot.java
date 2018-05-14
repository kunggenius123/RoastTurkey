import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.requests.restaction.AuditableRestAction;

import java.time.*;

import javax.annotation.CheckReturnValue;


public class App extends ListenerAdapter
{
	public static final String token = NDIyMjQwNTIyNjE1MTI4MDc0.Dds29Q.EoCoV4MpJhGvIA_7DJ3T76skgCs;
	public static final String prefix = "r]";
	public static final String CLIENT_ID = "422240522615128074";
	Random r = new Random();
	boolean clean = false;
	boolean restrict = false;
	String rword;
	String[] art = {
			"â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆ]99%", "Musicâ™©â™ªâ™«â™¬ Volume: â– â–‚ â–ƒ â–„ â–… â–† â–ˆ 100 %",
			" WE HAVE TAKEN OVERâ–‘ \nâ–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–Œâ–‘ â–Œ\nâ–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘ â–‘ \nâ–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆ ]â–„â–„â–„â–„â–„â–„â–„â–„â–„-----------â—\nâ–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‚â–„â–…â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–…â–„â–ƒâ–‚\nâ–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘â–‘Iâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆ].",
			"|^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ^ ||____\n| The STFU Truck!                     |\n}}}}!!!||||||}}}}}}|||||||||||||||||}}\n|(@)@)=====|(@)(@)==|(@)    ",
			"â™«â™ª.Ä±lÄ±lÄ±ll|Ì…Ì²Ì…â—Ì…Ì²Ì…|Ì…Ì²Ì…=Ì…Ì²Ì…|Ì…Ì²Ì…â—Ì…Ì²Ì…|llÄ±lÄ±lÄ±.â™«â™ª", "Â¯Â¯Ì¿Ì¿Â¯Ì¿Ì¿'Ì¿Ì¿Ì¿Ì¿Ì¿Ì¿Ì¿'Ì¿Ì¿'Ì¿Ì¿Ì¿Ì¿Ì¿'Ì¿Ì¿Ì¿)Í‡Ì¿Ì¿)Ì¿Ì¿Ì¿Ì¿ 'Ì¿Ì¿Ì¿Ì¿Ì¿Ì¿|ÌµÍ‡Ì¿Ì¿|=(â€¢ÌªÌ€â—Ì)=o|ÌµÍ‡Ì¿Ì¿|'Ì¿Ì¿ Ì¿ Ì¿Ì¿",
			"Â°ÂºÂ¤Ã¸,Â¸Â¸,Ã¸Â¤ÂºÂ°`Â°ÂºÂ¤Ã¸,Â¸,Ã¸Â¤Â°ÂºÂ¤Ã¸,Â¸Â¸,Ã¸Â¤ÂºÂ°`Â°ÂºÂ¤Ã¸,Â¸", "[{-_-}] ZZZzz zz z...",
			"Ù©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶ |==|iiii|>----- ", "d[ o_0 ]b ×¡â‚ªâ‚ªâ‚ªâ‚ªÂ§|(Îžâ‰¥â‰¤â‰¥â‰¤â‰¥â‰¤ÎžÎžÎžÎžÎžÎžÎžÎžÎžÎž>",
			"Hello I am Bender  Â¦ÌµÌ± ÌµÌ± ÌµÌ± ÌµÌ± ÌµÌ±(Ì¢ Ì¡Ì…Í‡â””Ì…Í‡â”˜Í‡Ì… (â–¤8×›âˆ’â—¦", ",.-~*Â´Â¨Â¯Â¨`*Â·~-.Â¸-(YEET!)-,.-~*Â´Â¨Â¯Â¨`*Â·~-.Â¸",
			"Ã˜)xxxxx[â•£â•—â•—â••â••â••=======â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€ â€Ž(|.__.)|   |(.__.|)",
			"<(''<)  <( ' ' )>  (> '')>\nÙ©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶Ù©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶Ù©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶Ù©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶Ù©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶Ù©(Ì¾â—Ì®Ì®ÌƒÌ¾â€¢ÌƒÌ¾)Û¶",
			"âœŒâŠ‚(âœ°â€¿âœ°)ã¤âœŒ   @xxxx[{::::::::::::::::::::::::::::::::::>", 
			"à¼¼â˜‰É·âŠ™à¼½     â™«â™ª.Ä±lÄ±lÄ±ll|Ì²Ì…Ì…â—‹Ì²Ì…Ì…|Ì²Ì…Ì…=Ì²Ì…Ì…|Ì²Ì…Ì…â—‹Ì²Ì…Ì…|llÄ±lÄ±lÄ±.â™«â™ª",
			"Ì´Ä±Ì´Ì´Ì¡ Ì¡ÍŒlÌ¡Ì¡Ì¡ Ì¡ÍŒlÌ¡*Ì¡Ì¡ Ì´Ì¡Ä±Ì´Ì´Ì¡ Ì¡Ì¡Í¡| Ì²:white_small_square:Ì²Í¡ Ì²Ì²Í¡:white_small_square:Ì²Ì²Í¡ Ì²|Ì¡Ì¡Ì¡ Ì¡ Ì´Ì¡Ä±Ì´Ì¡Ì¡ Ì¡ÍŒlÌ¡Ì¡Ì¡._.",
			"(à² _à² ) [Ì²Ì…$Ì²Ì…(Ì²Ì…100000000000Ì²Ì…)Ì²Ì…$Ì²Ì…]", "(â•¯Â°â–¡Â°ï¼‰â•¯ï¸µ â”»â”â”»   áƒš(à² ç›Šà² áƒš)   â”¬â”€â”¬ ãƒŽ( ã‚œ-ã‚œãƒŽ)",
			"â”(-_-)â”›â”—(-_-ï»¿ )â”“â”—(-_-)â”›â”(-_-)â”“   â–‚â–ƒâ–…â–‡â–ˆâ–“â–’â–‘Û©ÛžÛ©        Û©ÛžÛ©â–‘â–’â–“â–ˆâ–‡â–…â–ƒâ–‚",
			"( â€¢_â€¢)O*Â¯`Â·.Â¸.Â·Â´Â¯`Â°Q(â€¢_â€¢ )    â•°(â—£ï¹â—¢)â•¯ ((Ì²Ì… Ì²Ì…(Ì²Ì…Missle( Ì²Ì…((>   Ñ§Ñ¦ Ñ§  ï¸µÍ¡ï¸µ  Ì¢ Ì± Ì§Ì±Î¹ÌµÌ±ÌŠÎ¹Ì¶Ì¨Ì± Ì¶Ì±   ï¸µ Ñ¦Ñ§  ï¸µÍ¡ ï¸µ   Ñ§ Ñ¦    ÌµÌ—ÌŠoÌµÌ–  ï¸µ  Ñ¦Ñ¦ Ñ§ ",
			"â™ªâ”(Â°.Â°)â”›â”—(Â°.Â°)â”“â”—(Â°.Â°)â”›â”(Â°.Â°)â”“ â™ª   â˜š (<â€¿<)â˜š"
	};
	String[] diss = {"You're the second dumbest thing to ever exist next to your brain", 
			"I heard they are giving away free goose crap at your favourite store, I thought you'd be of interest",
			"Your ego is the second biggest thing in the world next to your weight",
			"Laughter is the best medicine if your face would be curing the world", "Brains aren't everything, in your case they're nothing",
			"I stepped on goose poo. It was smarter than you, and smells better too",
			"Your ugliness is similar to the sun, it can make people go blind", "I like what you did with your hair, how it comes out of your fingernails",
			"Iâ€™m trying my absolute hardest to see things from your perspective, but I just canâ€™t get my head that far up my butt",
			"The car behind you isn't wrecked so we know you haven't been driving it",
			"Stupidity is not a crime, so you're free to go", "You could be very useful in the army; because ugliness kills faster than any gun or bomb",
			"We all sprang from apes, except for you", "What's the most dense thing in your skull? Oh yah, it was air",
			"I'd love to jump from your ego to your IQ, but too bad I'd already be dead when I'm done", "They say friends come and go, but family is forever. Too bad your friends just go",
			"Riddle: There were kids sitting at a table, when suddenly out of nowhere they started laughing to death. Why?\nAnswer: They saw your face",
			"If humans IQ were stones, yours could replace an atom", "They say life is like a box of chocolates, since thats what your life is all about",
			"I don't know what makes you so idiotic, but it really works", "If you ran like your mouth, you'd be in really good shape",
			"If karma doesn't hit you in the face, I gladly will as an improvment", "Keep rolling your eyes, maybe you'll find a brain back there", "I'm so sorry when I hurt your feelings and called you stupid.\nI thought you already knew",
			"I miss you like an idiot misses a point", "90% of your beauty can be removed with a Kleenex",
			"I don't shut up, I grow up. But when I look at you, I throw up"};
	String[] funny = {"I hate it when people are at your house and ask 'Do you have a bathroom' No, we pee in the yard", 
			"What do you call someone that doesn't fart in public? A private tutor",
			"Only genius say these words fast: Eye, Yam, Stew, Peed", 
			"Police: *Knock Knock*\nMe: Who is it?\nPolice: The police!\nMe: what do you want\nPolice: To talk\nMe: How many of there are you\nPolice: 2\nMe: Go talk to each other",
			"Don't fart in an Apple Store because they don't have Windows", "The doctor told me to eat more greens, so I went on a dye-it",
			"You call me a bitch.\nA bitch is a dog.\nDogs bark.\nBark is on trees.\nTrees are in nature.\nNature is beautiful and so am I.\nSo thanks for the compliment!",
			"You remind me of my chinese friend . . . Ug Lee",
			"Mom: Are you talking back to me!?\nKid: Well yah that's how communication works",
			"Him: If you look at your keyboard you see U and I together.\nHer: Yah and right under you see JK",
			"Teacher: Why are you talking during class?\nKid: Why are you teaching in the middle of my conversation"
			};
	String[] quotes = {"Don't go through life, grow through life - Eric Butterworth", "Take a chance! All life is chance. The man who goes the farthest is generally the one who is willing to dare. - Dale Carneige",
			"We were all humans until\nRace disconnected us\nReligion seperated us\nPolitics divided us\nAnd wealth classified us\n - Joyner Lucas", "A ship is always safe at shore but that's not what it's built for - Albert Einstein",
			"Who are you to judge the life I live?\nI am not perfect and I don't have to be!\nBefore you start pointing fingers, make sure your hands are clean. - Bob Marley",
			"Life doesn't require that we be the best, only that we try our best. - H. Jackson Brown Jr.",
			"Remembering that I'll be dead\nsoon is the most important\ntool I've encountered to\nhelp me make the biggest choices in life. - Steve Jobs",
			"Everybody is a genius. But if you judge a fish by its ability to climb a tree,\nit will live its whole life believing it is stupid. - Albert Einstein",
			"Live as if you were to die tommorrow.\nLearn as if you were to live forever. - Mahatma Gandhi",
			"If you want to live a happy life, tie it to a goal, not to people or things. - Albert Einstein",
			"Life is 10% what happens to you and 90% how you react to it. - Charles R. Swindoll",
			"You'll turn out ordinary if you're not careful. - Ann Brashares", "Anything can happen to you if you let it. - Marry Poppins",
			"Jake Paul and Logan Paul are the most cancerous clickbaiters in the universe - Everyone",
			"Be like a proton, always positive. - Pinterest"};
	String[] food = {":turkey::turkey::turkey::turkey::turkey::turkey: :) just don't eat me plz, I gave you this feast", ":cherries::cherries::cherries::cherries::cherries: Fruits, eh?", 
			":doughnut::doughnut::doughnut::doughnut::doughnut: Some junk food for you",
			":hamburger::hamburger::hamburger::hamburger::hamburger: Hamburgers for you!",
			":cheese::cheese::cheese::cheese::cheese::cheese: Yum!", ":sushi::sushi::sushi::sushi::sushi::sushi: Yummy! Sushi!",
			":lollipop: :chocolate_bar::dango: :candy: :oden::lollipop: :chocolate_bar::dango: :candy: :oden: MMMM! Them candy!"};
	String[] nospam = {"general"};
	//don't mind the bad words
	String[] cursewords = {"shit", "fuck", "dick", "prick", "hoe", "thot", "whore", "uckers", "ass", "bitch"};
    public static void main( String[] args ) throws Exception
    {
    	
	    JDA jda = new JDABuilder(AccountType.BOT).setToken(token).buildBlocking();
	    jda.addEventListener(new App());
	    	
    	
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
    	MessageChannel channel = event.getChannel();
    	User user = event.getAuthor();
    	Message message = event.getMessage();
    	String msg = message.getContentDisplay();
    	Guild guild = event.getGuild();
	    List<Member> members = event.getTextChannel().getMembers();
	    int memberCount = 0;
    	if(msg.equalsIgnoreCase(prefix + "help")){
    		String m = HelpMsgText.funmsg + HelpMsgText.modmsg;
    				
    		channel.sendMessage(m).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "ping")){
    		String m = user.getName() + " says PONG!";
    		channel.sendMessage(m).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "art")){
    		int a = r.nextInt(art.length);
    		String m = art[a];
    		channel.sendMessage(m).queue();
    	}
    	else if(msg.startsWith(prefix + "diss")){
    		if (message.getMentionedUsers().isEmpty())
            {
                channel.sendMessage("You must mention 1 or more peoplez diss!").queue();
            }
    		else {
    			List<User> mentionedUsers = message.getMentionedUsers();
    			for(User u : mentionedUsers){
		    		int a = r.nextInt(diss.length);
		    		String d = diss[a];
		    		String m = "Hey " + u.getAsMention() + " " + d;
		    		channel.sendMessage(m).queue();
    			}
    		}
    	}
    	else if(msg.equalsIgnoreCase(prefix + "quotes")){
    		int b = r.nextInt(quotes.length);
    		String m = user.getName() + " says " + quotes[b];
    		channel.sendMessage(m).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "joke")){
    		int e = r.nextInt(funny.length);
    		String m = user.getName() + " says " + funny[e];
    		channel.sendMessage(m).queue();
    	}
    	else if(msg.startsWith(prefix + "food")){
    		if (message.getMentionedUsers().isEmpty())
            {
                channel.sendMessage("You must mention 1 or more peoplez to be give food to!").queue();
            }
    		else {
    			List<User> mentionedUsers = message.getMentionedUsers();
    			for(User u : mentionedUsers){
		    		int a = r.nextInt(food.length);
		    		String d = food[a];
		    		String m = u.getAsMention() + " " + d;
		    		channel.sendMessage(m).queue();
    			}
    		}
    	}
    	else if(msg.equalsIgnoreCase(prefix + "time")){
    		LocalDate d = LocalDate.now();
    		channel.sendMessage(d.toString()).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "tom")){
    		LocalDate d = LocalDate.now().plusDays(1);
    		channel.sendMessage(d.toString()).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "century")){
    		LocalDate d = LocalDate.now().plusYears(100);
    		channel.sendMessage(d.toString()).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "decade")){
    		LocalDate d = LocalDate.now().plusYears(10);
    		channel.sendMessage(d.toString()).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "millenium")){
    		LocalDate d = LocalDate.now().plusYears(1000);
    		channel.sendMessage(d.toString()).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "servermade")){
    		LocalDate d = guild.getCreationTime().toLocalDate();
    		String n = guild.getName();
    		channel.sendMessage(n + " was created on " + d).queue();
    	}
    	else if(msg.contains("$")){
    		String c = "()=={:money_mouth::money_mouth::money_mouth::money_mouth::money_mouth:===========>";
    		channel.sendMessage(c).queue();
    	}
    	else if(msg.toLowerCase().contains("lol")){
    		String c = "Sorry i drop my smallpack o doritos â–²â–¼â–¶â—€â–¼â–²â–²â–¼â–¶â–¼â–²â–²â–¼â–¶â—€â–¶â–²â–²â–¶â–¶â–¼â–²â–¶â–¶â–¶â–¼â–²â—€â—€â–¶â–¼â—€â–¶â–¼â–¶â–¶â—€â–¼â–²â—€â–¶â–²â–¼â–¶â–¶â–¼â–¼â–²â—€â–¶â–¼â–² :yum:";
    		channel.sendMessage(c).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "avatar")){
    		Member m = guild.getMember(user);
    		LocalDate d = user.getCreationTime().toLocalDate();
    		LocalDate da = m.getJoinDate().toLocalDate();
    		String c = "`"+user.getName()+"`:" + "\n\n" + user.getAvatarUrl() + "\n\n **Account created**: " + d + "\nJoined **" + guild.getName() + "**  on " + da;
    		channel.sendMessage(c).queue();
    	}
    	else if(msg.equalsIgnoreCase(prefix + "members")){
    		for(Member m : members){
    			if(m.isOwner()){
    				channel.sendMessage("`" + m.getEffectiveName().toString() + "`  **Owner**     Status: " + m.getOnlineStatus()).queue();
    			}
    			else if(m.getUser().isBot()){
    				continue;
    			}
    			else{
    				LocalDate d = m.getJoinDate().toLocalDate();
    				channel.sendMessage("`" + m.getEffectiveName().toString() + "`    Joined " + "**" + guild.getName() + "**" + "    On " + d + "   Status: " + m.getOnlineStatus()).queue();
    			}
    		}
    	}
    	else if(msg.equalsIgnoreCase(prefix + "bots")){
    		for(Member m : members){
    			if(m.getUser().isBot()){
    				LocalDate d = m.getJoinDate().toLocalDate();
    				channel.sendMessage("`" + m.getEffectiveName().toString() + "`:  Joined " + "**" + guild.getName() + "**" + "    On " + d + "   Status: " + m.getOnlineStatus()).queue();
    			}
    		}
    	}
    	else if(msg.startsWith(prefix + "kick")){
    		String c[] = msg.split(" ");
    		String m = c[c.length - 1];
    		if (message.isFromType(ChannelType.TEXT))
            {
                //If no users are provided, we can't kick anyone!
                if (message.getMentionedUsers().isEmpty())
                {
                    channel.sendMessage("You must mention 1 or more peoplez to be kicked!").queue();
                }
                else
                {
                    Guild g = event.getGuild();
                    Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.

                    //Loop over all mentioned users, kicking them one at a time. Mwauahahah!
                    List<User> mentionedUsers = message.getMentionedUsers();
                    for (User u : mentionedUsers)
                    {
                        Member me = g.getMember(u);  //We get the member object for each mentioned user to kick them!

                        //We need to make sure that we can interact with them. Interacting with a Member means you are higher
                        // in the Role hierarchy than they are. Remember, NO ONE is above the Guild's Owner. (Guild#getOwner())
                        if (!selfMember.canInteract(me))
                        {
                            // use the MessageAction to construct the content in StringBuilder syntax using append calls
                            channel.sendMessage("Cannot kick member: ")
                                   .append(me.getEffectiveName())
                                   .append(", they are higher than me!!! BAWK!")
                                   .queue();
                            continue;   //Continue to the next mentioned user to be kicked.
                        }

                        //Remember, due to the fact that we're using queue we will never have to deal with RateLimits.
                        // JDA will do it all for you so long as you are using queue!
                        guild.getController().kick(me).queue(
                        	
                        	success -> channel.sendMessage("I kicked ").append(me.getEffectiveName()).append(" because ").append("**" + m + "**").queue(),
                            error ->
                            {
                                //The failure consumer provides a throwable. In this case we want to check for a PermissionException.
                                if (error instanceof PermissionException)
                                {
                                    PermissionException pe = (PermissionException) error;
                                    Permission missingPermission = pe.getPermission();  //If you want to know exactly what permission is missing, this is how.
                                                                                        //Note: some PermissionExceptions have no permission provided, only an error message!

                                    channel.sendMessage("PermissionError kicking [")
                                           .append(me.getEffectiveName()).append("]: ")
                                           .append(error.getMessage()).queue();
                                }
                                else
                                {
                                    channel.sendMessage("Unknown error while kicking [")
                                           .append(me.getEffectiveName())
                                           .append("]: <").append(error.getClass().getSimpleName()).append(">: ")
                                           .append(error.getMessage()).queue();
                                }
                            });
                    }
                }
            }
            else
            {
                channel.sendMessage("This is a server-only command! BAWK!").queue();
            }
    	}
    	else if(msg.startsWith(prefix + "spam")){
    		String[] c = msg.split(" ");
    		int strike = 0;
    		int t = Integer.parseInt(c[c.length - 1]);
    		if(c.length <= 2){
    			channel.sendMessage("Type what you want to spam and how much times. For example: r]spam k 10").queue();
    		}
    		else{
	    		for(int i = 0; i < t; i++){
	    			channel.sendMessage(c[1]).queue();
	    			try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    		}
    		}
    	}
    	else if(msg.startsWith(prefix + "clean")){
    		clean = true;
    	}
    	else if(msg.startsWith(prefix + "unclean")){
    		clean = false;
    	}
    	if(clean){
    		for (String i:cursewords){
    			if(msg.toLowerCase().contains(i)){
    				message.delete().queue();
    			}
    		}
    	}
    	else if(msg.startsWith(prefix + "troll")){
    		String[] p = msg.split(" ");
    		int time = Integer.parseInt(p[p.length - 1]);
    		if (message.isFromType(ChannelType.TEXT))
            {
                //If no users are provided, we can't kick anyone!
                if (message.getMentionedUsers().isEmpty())
                {
                    channel.sendMessage("You must mention 1 or more peoplez to be punished!").queue();
                }
                else
                {
                    Guild g = event.getGuild();
                    Member selfMember = guild.getSelfMember();  //This is the currently logged in account's Member object.
                                                                // Very similar to JDA#getSelfUser()!
                    //Loop over all mentioned users, kicking them one at a time. Mwauahahah!
                    List<User> mentionedUsers = message.getMentionedUsers();
                    for (User u : mentionedUsers)
                    {
                        Member me = g.getMember(u);  //We get the member object for each mentioned user to kick them!

                        //We need to make sure that we can interact with them. Interacting with a Member means you are higher
                        // in the Role hierarchy than they are. Remember, NO ONE is above the Guild's Owner. (Guild#getOwner())

                        if (me.isOwner()){
                        	channel.sendMessage("Cannot punish owner knucklehead").queue();
                        }
                        //Remember, due to the fact that we're using queue we will never have to deal with RateLimits.
                        // JDA will do it all for you so long as you are using queue!
                        else{
                        	for(int i = 0; i < time; i++){
                        		int ra = r.nextInt(diss.length);
                        		channel.sendMessage("O great lord of stupidity " + me.getAsMention() + " " + diss[ra]).queue();
                        		try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block 
									e.printStackTrace();
								}
                        	}
                        }
                           
                    }
                }
             
            }
    		
        	   
    		
    	}
    	
    }
}
    	

