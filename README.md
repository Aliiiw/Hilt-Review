# Hilt-Review

Hilt-Review is an Android/Kotlin practice project for reviewing dependency injection with Hilt. It demonstrates simple value injection, custom qualifiers, named dependencies, Android resource injection, and a Room-backed screen wired through injected DAO, repository, entity, and RecyclerView adapter dependencies.

## Features

- Hilt application setup with `@HiltAndroidApp`.
- Activity injection with `@AndroidEntryPoint`.
- `@Module`, `@InstallIn`, and `@Provides` examples.
- `@Named` dependency examples for strings.
- Custom qualifier example with `@UserFullName`.
- Injecting a string from Android resources using `@ApplicationContext`.
- Room database setup with a Hilt module.
- Injected `UserDao`, `UserDatabase`, `User`, `DatabaseRepository`, and `UserAdapter`.
- RecyclerView backed by `AsyncListDiffer` and `DiffUtil`.
- Simple form to add users to the local Room database.

## Tech Stack

- Kotlin
- Android XML layouts
- ViewBinding
- Hilt
- Room
- RecyclerView
- AppCompat
- Material Components
- ConstraintLayout

## Project Structure

```text
app/src/main/java/ir/alirahimi/hilt
├── MyApp.kt                         # Hilt application class
├── MainActivity.kt                  # Simple Hilt string/resource injection example
├── di
│   ├── AppModule.kt                 # Resource string provider
│   ├── MainModule.kt                # Named and qualified string providers
│   └── qualifier/UserFullName.kt    # Custom qualifier
├── room
│   ├── MyActivity.kt                # Room + Hilt demo screen
│   ├── UserAdapter.kt               # Injected RecyclerView adapter
│   ├── db
│   │   ├── Entity.kt
│   │   ├── UserDao.kt
│   │   └── UserDatabase.kt
│   ├── di/DatabaseModule.kt         # Room/Hilt providers
│   └── repository/DatabaseRepository.kt
└── util/Constants.kt
```

## Main Screens

### `MainActivity`

Shows a string injected by Hilt. The code includes examples for using normal injection, `@Named`, and a custom qualifier.

### `MyActivity`

The launcher activity. It lets the user type a name, save it into Room, display all stored users in a RecyclerView, and tap an item to show its ID/name in a toast.

## Hilt Examples Included

- Singleton providers in `SingletonComponent`.
- Context-aware provider using `@ApplicationContext`.
- Named values with `@Named(Constants.NAMED_USER_NAME)` and `@Named(Constants.NAMED_RES_STRING)`.
- Custom qualifier with `@UserFullName`.
- Constructor injection for `DatabaseRepository`.
- Adapter injection with `@Inject constructor()`.

## Room Setup

The local database stores a simple `User` entity:

- `id`: auto-generated primary key
- `name`: user-entered text

The DAO supports inserting users and reading all users.

## Getting Started

1. Clone the repository.
2. Open it in Android Studio.
3. Sync Gradle.
4. Run the `app` configuration on an Android device or emulator.

## Build

```bash
./gradlew assembleDebug
```

## Notes

This repository is a learning/review project for Hilt concepts, not a production app. Some choices, such as `allowMainThreadQueries()`, are useful for a small demo but should be replaced with coroutine/background access in production code.
