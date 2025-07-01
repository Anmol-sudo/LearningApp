package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(
    // Body Large: For longer passages of text
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom font family
        fontWeight = FontWeight.Normal, // A suitable weight for body text
        fontSize = 16.sp, // A standard size for body text
        lineHeight = 24.sp, // Example line height for readability
        letterSpacing = 0.5.sp // Example letter spacing
    ),

    // Headline Large: For short, high-emphasis text, especially on smaller screens
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom font family
        fontWeight = FontWeight.Bold, // A strong weight for headlines
        fontSize = 28.sp, // A relatively large size for headlines
        lineHeight = 36.sp, // Example line height for headlines
        letterSpacing = 0.sp // Example letter spacing
    ),

    // Contact Name Typography (e.g., using Title Medium)
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom font family
        fontWeight = FontWeight.SemiBold, // Use a slightly bolder weight for the name
        fontSize = 16.sp, // A good size for a medium emphasis title
        lineHeight = 24.sp, // Appropriate line height for readability
        letterSpacing = 0.15.sp // Standard letter spacing
    ),

    // Contact Number Typography (e.g., using Body Medium or Label Medium)
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom font family
        fontWeight = FontWeight.Normal, // Use a regular weight for the number
        fontSize = 14.sp, // A slightly smaller size than the name
        lineHeight = 20.sp, // Adjust line height as needed
        letterSpacing = 0.25.sp // Example letter spacing
    ),
)
