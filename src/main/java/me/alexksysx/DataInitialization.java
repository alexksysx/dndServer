package me.alexksysx;

import me.alexksysx.model.Size;
import me.alexksysx.model.WeaponType;
import me.alexksysx.repo.SizeRepository;
import me.alexksysx.repo.WeaponTypeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class DataInitialization {

    @Bean
    public boolean initSize(SizeRepository sizeRepository) {
        ArrayList<Size> sizeArrayList = new ArrayList<>();
        sizeArrayList.add(new Size(1L, "Tiny", "2 1/2 by 2 1/2 ft."));
        sizeArrayList.add(new Size(2L, "Small", "5 by 5 ft."));
        sizeArrayList.add(new Size(3L, "Medium", "5 by 5 ft."));
        sizeArrayList.add(new Size(4L, "Large", "10 by 10 ft."));
        sizeArrayList.add(new Size(5L, "Huge", "15 by 15 ft."));
        sizeArrayList.add(new Size(6L, "Gargantuan", "20 by 20 ft. or larger"));
        for(Size size: sizeArrayList) {
            if (!sizeRepository.existsSizeByNameAndSpace(size.getName(), size.getSpace()))
            {
                sizeRepository.save(size);
            }
        }
        return true;
    }

    @Bean
    public boolean initWeaponType(WeaponTypeRepository weaponTypeRepository) {
        ArrayList<WeaponType> weaponTypes = new ArrayList<>();
        weaponTypes.add(new WeaponType(1L, "Ammunition", "You can use a weapon that has the Ammunition property to make a ranged Attack only if you have Ammunition to fire from the weapon. Each time you Attack with the weapon, you expend one piece of Ammunition. Drawing the Ammunition from a Quiver, case, or other container is part of the Attack (you need a free hand to load a one-handed weapon). At the end of the battle, you can recover half your expended Ammunition by taking a minute to Search the battlefield. If you use a weapon that has the Ammunition property to make a melee Attack, you treat the weapon as an Improvised Weapon (see “Improvised Weapons” later in the section). A sling must be loaded to deal any damage when used in this way."));
        weaponTypes.add(new WeaponType(2L, "Finesse", "When Making an Attack with a finesse weapon, you use your choice of your Strength or Dexterity modifier for the Attack and Damage Rolls. You must use the same modifier for both rolls."));
        weaponTypes.add(new WeaponType(3L, "Heavy", "Small creatures have disadvantage on Attack rolls with heavy Weapons. A heavy weapon’s size and bulk make it too large for a Small creature to use effectively."));
        weaponTypes.add(new WeaponType(4L, "Light", "A light weapon is small and easy to handle, making it ideal for use when fighting with two Weapons."));
        weaponTypes.add(new WeaponType(5L, "Loading", "Because of the time required to load this weapon, you can fire only one piece of Ammunition from it when you use an action, Bonus Action, or Reaction to fire it, regardless of the number of attacks you can normally make."));
        weaponTypes.add(new WeaponType(6L, "Range", "A weapon that can be used to make a ranged Attack has a range in parentheses after the Ammunition or thrown property. The range lists two numbers. The first is the weapon’s normal range in feet, and the second indicates the weapon’s long range. When attacking a target beyond normal range, you have disadvantage on the Attack roll. You can’t Attack a target beyond the weapon’s long range."));
        weaponTypes.add(new WeaponType(7L, "Reach", "This weapon adds 5 feet to your reach when you Attack with it, as well as when determining your reach for Opportunity Attacks with it."));
        weaponTypes.add(new WeaponType(8L, "Special", "A weapon with the special property has unusual rules governing its use, explained in the weapon’s description."));
        weaponTypes.add(new WeaponType(9L, "Thrown", "If a weapon has the thrown property, you can throw the weapon to make a ranged Attack. If the weapon is a melee weapon, you use the same ability modifier for that Attack roll and damage roll that you would use for a melee Attack with the weapon. For example, if you throw a Handaxe, you use your Strength, but if you throw a Dagger, you can use either your Strength or your Dexterity, since the Dagger has the finesse property."));
        weaponTypes.add(new WeaponType(10L, "Two-Handed", "This weapon requires two hands when you Attack with it."));
        weaponTypes.add(new WeaponType(11L, "Versatile", "This weapon can be used with one or two hands. A damage value in parentheses appears with the property—the damage when the weapon is used with two hands to make a melee Attack."));
        weaponTypes.add(new WeaponType(12L, "Improvised Weapons", "Sometimes characters don’t have their Weapons and have to Attack with whatever is at hand. An Improvised Weapon includes any object you can wield in one or two hands, such as broken glass, a table leg, a frying pan, a wagon wheel, or a dead Goblin.\n" +
                "\n" +
                "Often, an Improvised Weapon is similar to an actual weapon and can be treated as such. For example, a table leg is akin to a club. At the GM’s option, a character proficient with a weapon can use a similar object as if it were that weapon and use his or her Proficiency Bonus.\n" +
                "\n" +
                "An object that bears no resemblance to a weapon deals 1d4 damage (the GM assigns a damage type appropriate to the object). If a character uses a ranged weapon to make a melee Attack, or throws a melee weapon that does not have the thrown property, it also deals 1d4 damage. An improvised thrown weapon has a normal range of 20 feet and a long range of 60 feet."));
        weaponTypes.add(new WeaponType(13L, "Silvered Weapons", "Some Monsters that have immunity or Resistance to nonmagical Weapons are susceptible to silver Weapons, so cautious adventurers invest extra coin to plate their Weapons with silver. You can silver a single weapon or ten pieces of Ammunition for 100 gp. This cost represents not only the price of the silver, but the time and expertise needed to add silver to the weapon without making it less effective."));
        for (WeaponType weaponType: weaponTypes) {
            if(!weaponTypeRepository.existsWeaponTypeByName(weaponType.getName())) {
                weaponTypeRepository.save(weaponType);
            }
        }
        return true;
    }

}
