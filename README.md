In English:
This code **(Test 5) ** is an automated Selenium test script designed to visit a specific website (https://developer.mozilla.org/en-US/docs/Web/WebDriver), switch between various themes, and verify whether the expected theme is successfully applied. It tests multiple themes, such as "light," "dark," and "os-default," in different sequences.

### Code Explanation

1. **Initial Setup:** 
   - The `URL` is defined at the beginning, and from the `main` method, it calls the `runAllTests()` method, which runs all theme sequences.

2. **`runAllTests()` Method:** 
   - Here, different theme sequences are defined, such as the first test case with themes in the sequence `"light", "dark", "os-default"` and other test cases with different orders.
   - For each theme sequence, it calls the `runThemeTest()` method.

3. **`runThemeTest(List<String> themes)` Method:** 
   - First, it creates a new `WebDriver` instance and navigates to the website.
   - Then, it switches themes sequentially by calling the `switchToTheme()` method and verifies each theme with the `verifyTheme()` method.
   - Finally, it checks whether the expected theme (the last theme in the sequence) is applied.

4. **`switchToTheme(WebDriver driver, String theme)` Method:** 
   - This method switches to a specified theme by clicking on the theme switcher button with the `.theme-switcher-menu` class.
   - Based on the `theme` variable, it selects the appropriate theme selector (e.g., `.icon-theme-light` for the `light` theme).
   - It then clicks the `themeButton` to change the theme and pauses for 2 seconds to ensure the theme applies correctly.

5. **`verifyTheme(WebDriver driver, String expectedTheme)` Method:** 
   - Here, it checks the `class` attribute of the `html` tag to see if it contains the `expectedTheme` name. If not, an assertion failure message is displayed.
   - If the theme is applied correctly, it prints a success message to the console (e.g., `"light theme applied successfully."`).

In bangla:
এই কোডটি** (Test 5 )** একটি স্বয়ংক্রিয় সেলেনিয়াম টেস্ট স্ক্রিপ্ট যা নির্দিষ্ট ওয়েবসাইটে (https://developer.mozilla.org/en-US/docs/Web/WebDriver) বিভিন্ন থিম স্যুইচ করে এবং প্রত্যাশিত থিমটি সফলভাবে প্রয়োগ হয়েছে কি না তা পরীক্ষা করে। এখানে একাধিক থিম আছে যেমন, "light," "dark," এবং "os-default," যেগুলোর উপর ভিত্তি করে বিভিন্ন টেস্ট কেস তৈরি করা হয়েছে।

### কোডের ব্যাখ্যা

1. **শুরুর অংশে:** `URL` এর মান নির্ধারণ করা হয়েছে এবং `main` মেথড থেকে `runAllTests()` মেথডটি কল করা হয়েছে, যা সকল থিম সিকোয়েন্স পরীক্ষা করে।

2. **`runAllTests()` মেথড:** 
    - এখানে বিভিন্ন থিমের ক্রম (sequence) নির্ধারণ করা হয়েছে, যেমন প্রথম টেস্টে থিম ক্রম `"light", "dark", "os-default"` এবং পরবর্তী টেস্টগুলোতে আলাদা ক্রমে থিমগুলো দেওয়া হয়েছে।
    - প্রতিটি থিম সিকোয়েন্সের জন্য `runThemeTest()` মেথডটি কল করা হয়েছে।

3. **`runThemeTest(List<String> themes)` মেথড:**
    - প্রথমে, একটি নতুন `WebDriver` ইন্সট্যান্স তৈরি করা হয়, এবং ওয়েবসাইটটিতে নেভিগেট করা হয়।
    - তারপর প্রতিটি থিম ক্রমানুসারে `switchToTheme()` মেথডের মাধ্যমে পরিবর্তন করা হয় এবং `verifyTheme()` মেথডের মাধ্যমে নিশ্চিত করা হয় যে সঠিক থিম প্রয়োগ হয়েছে।
    - সবশেষে প্রত্যাশিত থিমটি (থিম সিকোয়েন্সের সর্বশেষ থিম) প্রয়োগ হয়েছে কিনা সেটি পুনরায় যাচাই করা হয়।

4. **`switchToTheme(WebDriver driver, String theme)` মেথড:**
    - এখানে নির্দিষ্ট থিমে স্যুইচ করার জন্য প্রথমে `.theme-switcher-menu` ক্লাসযুক্ত বাটনে ক্লিক করা হয়।
    - তারপর `theme` ভেরিয়েবল অনুযায়ী বিভিন্ন থিম সিলেক্টর নির্ধারণ করা হয় (যেমন `.icon-theme-light` `light` থিমের জন্য)।
    - `themeButton` বাটনে ক্লিক করার মাধ্যমে থিম পরিবর্তন করা হয় এবং ২ সেকেন্ড থেমে যাওয়া হয়, যাতে থিম সঠিকভাবে প্রয়োগ হয়।

5. **`verifyTheme(WebDriver driver, String expectedTheme)` মেথড:**
    - এখানে `html` ট্যাগের ক্লাস অ্যাট্রিবিউটটি চেক করে দেখা হয় যে `expectedTheme` নামটি ক্লাসের মধ্যে আছে কিনা। যদি না থাকে, তাহলে একটি অ্যাসারশন ফেইল মেসেজ দেখানো হয়।
    - সঠিক থিম প্রয়োগ হলে কনসোলে একটি সফল বার্তা (যেমন `"light theme applied successfully."`) প্রিন্ট হয়।
