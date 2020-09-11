# Android-Task-DevFolio
> Hello! :wave: This task was given to me as a challenge from the **Devfolio** & **Fold** Team for Internship.

I'll honestly quote that it was definitely a very challenging task :smiley: and took many many hours of research across hundreds of pages of Android documentation before I could make what I've now!

- Link to the Android Task: [Here](https://www.notion.so/devfolio/Android-Task-2586-Labs-044b886b93b34092b4f85aeec3be4ecc)

## My Implementation:

[![Watch the video here](https://github.com/CapTen101/Android-Task-DevFolio/raw/master/PosterFinal.png)](https://drive.google.com/file/d/1Qa9UrtOg1x-f6nnO7Dx-zeonXq6T2X9B/view?usp=sharing)

## Software Architecture

I have tried to follow a *modular approach* to the task on hand. Every component (`Activity/Fragment/Class`) has it's own package making the code to easier to test and debug in case of bugs and errors.

## Commit Style

I've tried to keep commit messages as relevant as possible so as to make it easier for the reader or collaborator to follow-up on the progress of the particular project.

## My Decisions and Implementation Details

I took *some key decisions* as to how I'll be able to implement the given task at hand: 
- Swipable Layout is created through `androidx.ViewPager`.
- The Adapter for the `ViewPager` was implemented through a custom `FragmentPageAdapter`. It maintains the `Fragment` by-default hence better to use and imeplement.
- The given custom `Cubic Bezier` animation was implemented through `PathInterpolator`.
- The Parallax Effect while scrolling the images was implemented through `ViewPager.PageTransformer`.
- Unit Testing is done through `JUnit4`, `Mockito` and `Espresso`.
- Variable Length `PageControl` is something which I tried through `ViewPager.PagerTabStrip`.
  - But couldn't achieve it due to less meagre resources available on this. :persevere:
But it couldn't be left altogether which is essentially not in the spirit of product-based software Engineering :no_mouth:.
  - I tried to implement atleast a very basic `TabLayout` to fulfill our need of a Slider or PageControl kind of layout to enhance the UI/UX and detect the sliding views of the OnBoarding `ViewPager`.
- The second task I couldn't implement was the animation of words being starting only after the previous word. I certainly could implement the `PathInterpolator` for the `Cubic Bezier` style of animation.
  - But the problem lied in the delaying of the animations. Somehow the `setStartDelay` method of the `.animate()` or even the `setStartOffSet()` of `Animation` class weren't behaving properly inside the fragment as they should. :confused:
  - I tried to block the animation of the next through running each animation on the UIThread (since it's synchronous and blocks the rest of the services before it completes itself) but to no avail.
  - Again there weren't many resources addressing this problem so I thought atleast I can equate the timing of the animations to suffice the initial development.
- I feel that a little external help could have led me to implement these but I refrained myself from asking anybody and decided to complete this all my myself. A great way to learn :grin:.

## Path to the APK:
Last but not the least, Path to generated APK for the readers to install is as follows:

    cd ./app/build/outputs/apk/debug/app-debug.apk
