package vinit.composetwo.workbeanchOne

import vinit.composetwo.R

data class Category(val imdId: Int, val title: String, val subTitle: String)

fun getCategoryList(): MutableList<Category> = mutableListOf<Category>()
    .apply {
        add(Category(R.drawable.ic_launcher_background, "Programming", "Learn Different Languages"))
        add(Category(R.drawable.signify_1, "Technology", "Learn Different Languages"))
        add(
            Category(
                R.drawable.heart_svgrepo_com,
                "Full stack Development",
                "Learn Different Languages"
            )
        )
        add(Category(R.drawable.ic_launcher_background, "DevOps", "Learn Different Languages"))
        add(Category(R.drawable.signify_1, "Programming", "Learn Different Languages"))
        add(Category(R.drawable.heart_svgrepo_com, "AI & ML", "Learn Different Languages"))
        add(Category(R.drawable.ic_launcher_background, "Backend", "Learn Different Languages"))
        add(Category(R.drawable.heart_svgrepo_com, "Backend", "Learn Different Languages"))
        add(Category(R.drawable.signify_1, "UI UX", "Learn Different Languages"))
        add(Category(R.drawable.ic_launcher_background, "Automation Testing", "Learn Different Languages"))
        add(Category(R.drawable.heart_svgrepo_com, "QA", "Learn Different Languages"))
    }
