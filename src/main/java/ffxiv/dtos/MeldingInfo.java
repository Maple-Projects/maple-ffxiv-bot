package ffxiv.dtos;

import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public class MeldingInfo {

/* Liste des jobs */
    
    EmbedBuilder scholar = new EmbedBuilder()
            .setTitle("Scholar")
            .addField("Critical Hit", "Aldo crit is OP. Use it on tankbuster instead of Excog because Aldo crit healing potency > Excog.")
            .addField("Determination", "Bigger heal and bigger damage")
            .addField("Spell Speed", "So you can spam broil")
            .setThumbnail("https://xivapi.com/cj/1/scholar.png");

    EmbedBuilder summoner = new EmbedBuilder()
            .setTitle("Summoner")
            .addField("Critical Hit", "Crits doubles or even triples your damage. Especially with bahamut and/or phoenix.")
            .addField("Direct Hit", "More chances of landing bigger hits")
            .addField("Determination", "Bigger base damage")
            .setThumbnail("https://xivapi.com/cj/1/summoner.png");

    EmbedBuilder whitemage = new EmbedBuilder()
            .setTitle("White Mage")
            .addField("Critical Hit", "Afflatus Misery + crit = That's a lot of damage. Afflatus solace crit compensate a gunbreaker that shoots himself in the head after you bene'd him")
            .addField("Determination", "Bigger base healing and damage")
            .setThumbnail("https://xivapi.com/cj/1/whitemage.png");

    EmbedBuilder astrologian = new EmbedBuilder()
            .setTitle("Astrologian")
            .addField("Critical Hit", "Afflatus Misery + crit = That's a lot of damage. Afflatus solace crit compensate a gunbreaker that shoots himself in the head after you bene'd him")
            .addField("Determination", "Bigger base healing and damage")
            .addField("Direct Hit", "More chances of landing bigger hits")
            .setThumbnail("https://xivapi.com/cj/1/whitemage.png");
    EmbedBuilder darkknight = new EmbedBuilder()
            .setTitle("Dark Knight")
            .addField("Skill Speed", "You need to get at least 5 Bloodspiller in a Delirium.")
            .addField("Direct Hit", "Delirium + Bloodspillers + Direct Hit = Juicy damage")
            .addField("Determination", "Bigger base damage")
            .setThumbnail("https://xivapi.com/cj/1/darkknight.png");

    EmbedBuilder paladin = new EmbedBuilder()
            .setTitle("Paladin")
            .addField("Critical Hit", "You would need skill speed, but your 80 gear should already give you 2.40s gcd. So just get more damage")
            .addField("Direct Hit", "More chances of landing bigger hits. Direct Hit supersede Determination so prioritise Direct Hit over Determination.")
            .addField("Determination", "Bigger base damage.")
            .setThumbnail("https://xivapi.com/cj/1/paladin.png");

    EmbedBuilder warrior = new EmbedBuilder()
            .setTitle("Warrior")
            .addField("Skill Speed", "You need to get most Fell cleave from your berserk.")
            .addField("Direct Hit", "Get the most damage out from your Fell cleave")
            .addField("Determination", "Bigger base damage")
            .setThumbnail("https://xivapi.com/cj/1/warrior.png");

    EmbedBuilder gunbreaker = new EmbedBuilder()
            .setTitle("Gunbreaker")
            .addField("Skill Speed", "-1320 for 2.40 GCD - Base No Mercy windows -1421 2.39 GCD - 'I want to be comfy' -1523 for 2.38 GCD - 'My ping is kinda bad'. Every 0.01 GCD difference adds 0.25 seconds of breathing room between No Mercy windows. If desyncing becomes an issue, delay your GCD slightly or opt for a slower GCD")
            .addField("Direct Hit", "When you hit your comfy GCD,  just go full Direct Hit")
            .addField("Determination", "Bigger base damage. Only meld this if Direct Hit is already maxed out on a gear.")
            .setThumbnail("https://xivapi.com/cj/1/gunbreaker.png");

    EmbedBuilder dancer = new EmbedBuilder()
            .setTitle("Dancer")
            .addField("Direct Hit", "Direct Hit >  Critical Hit because you already have devilment.")
            .addField("Critical Hit", "Only meld this if you cannot meld Direct Hit")
            .addField("Determination", "Only meld this if you cannot meld Direct Hit nor Critical Hit")
            .setThumbnail("https://xivapi.com/cj/1/dancer.png");

    EmbedBuilder bard = new EmbedBuilder()
            .setTitle("Bard")
            .addField("Critical Hit", "Critical Hit scales well when 2500+. Critical Hit + Direct Hit should be at 5000 or so")
            .addField("Direct Hit", "You need to prioritise both of them. Having too much Crit and too low Direct Hit will hurt your base damage.")
            .setThumbnail("https://xivapi.com/cj/1/bard.png");

    EmbedBuilder machinist = new EmbedBuilder()
            .setTitle("Machinist")
            .addField("Critical Hit", "You go full damage because you lack support actions. Max Critical hit whenever you can")
            .addField("Direct Hit", "Crit is capped? go Direct Hit.")
            .setThumbnail("https://xivapi.com/cj/1/machinist.png");

    EmbedBuilder blackmage = new EmbedBuilder()
            .setTitle("Black Mage")
            .addField("Spell Speed", "A lot of people run without spell speed and go full crit. However, you might have to cancel your casting and you will lost a lot of DPS. Find your comfortable amount of Spell Speed then go damage. This will depend on you. However, dont use spell speed if you share gear with other jobs.")
            .addField("Direct Hit", "You will deal a constant amount of damage if you prioritise Direct Hit.")
            .addField("Critical Hit", "Critical hit is still a very good secondary stat.")
            .addField("Melding for shared gears", "Here is an example of melding if you share your gear with other jobs: https://ffxiv.ariyala.com/1C41J")
            .addField("Melding OTP Black Mages", "Here is an example of melding if you don't share your casting gears: https://ffxiv.ariyala.com/1BZUX")
            .setThumbnail("https://xivapi.com/cj/1/blackmage.png");

    EmbedBuilder redmage = new EmbedBuilder()
            .setTitle("Red Mage")
            .addField("Critical Hit", "Crit whenever possible.")
            .addField("Direct Hit", "Crit is maxed out? Go Direct Hit. You need at least 1700 Direct Hit")
            .addField("Determination", "Maxed out in Crit and Direct Hit? Go Determination. Do NOT go spell speed because this will fuck your rotation. It causes rotation issues and because it doesn't do anything for all the abilities you have that aren't spells a.k.a your melee rotation + fleche and contre sixte")
            .setThumbnail("https://xivapi.com/cj/1/redmage.png");

    EmbedBuilder samurai = new EmbedBuilder()
            .setTitle("Samurai")
            .addField("Skill Speed", "Comfy Skill speed (around 2.38 gcd without shifu)")
            .addField("Direct Hit", "Direct Hit >>>>> Critical Hit")
            .addField("Critical Hit", "Only meld this if Direct Hit is maxed out.")
            .setThumbnail("https://xivapi.com/cj/1/samurai.png");

    EmbedBuilder dragoon = new EmbedBuilder()
            .setTitle("Dragoon")
            .addField("Direct Hit", "Test")
            .addField("Determination", "Test")
            .addField("Critical Hit", "Test")
            .setThumbnail("https://xivapi.com/cj/1/dragoon.png");

    EmbedBuilder ninja = new EmbedBuilder()
            .setTitle("Ninja")
            .addField("Direct Hit", "Test")
            .addField("Determination", "Test")
            .addField("Critical Hit", "Test")
            .setThumbnail("https://xivapi.com/cj/1/ninja.png");
    EmbedBuilder monk = new EmbedBuilder()
            .setTitle("Monk")
            .addField("Direct Hit", "Test")
            .addField("Determination", "Test")
            .addField("Critical Hit", "Test")
            .setThumbnail("https://xivapi.com/cj/1/monk.png");
/* Methods */
    public EmbedBuilder getSummoner() {
        return summoner;
    }

    public EmbedBuilder getScholar() {
        return scholar;
    }

    public EmbedBuilder getWhitemage() {
        return whitemage;
    }

    public EmbedBuilder getDarkknight() {
        return darkknight;
    }

    public EmbedBuilder getAstrologian() {
        return astrologian;
    }

    public EmbedBuilder getPaladin() {
        return paladin;
    }

    public EmbedBuilder getWarrior() {
        return warrior;
    }

    public EmbedBuilder getGunbreaker() {
        return gunbreaker;
    }

    public EmbedBuilder getDancer() {
        return dancer;
    }

    public EmbedBuilder getBard() {
        return bard;
    }

    public EmbedBuilder getMachinist() {
        return machinist;
    }

    public EmbedBuilder getBlackmage() {
        return blackmage;
    }

    public EmbedBuilder getRedmage() {
        return redmage;
    }

    public EmbedBuilder getSamurai() {
        return samurai;
    }

    public EmbedBuilder getDragoon() {
        return dragoon;
    }

    public EmbedBuilder getMonk() {
        return monk;
    }
    public EmbedBuilder getNinja() {
        return ninja;
    }
}
