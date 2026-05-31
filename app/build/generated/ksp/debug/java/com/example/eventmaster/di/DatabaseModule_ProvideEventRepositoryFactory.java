package com.example.eventmaster.di;

import com.example.eventmaster.data.local.database.EventMasterDatabase;
import com.example.eventmaster.data.repository.EventRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideEventRepositoryFactory implements Factory<EventRepository> {
  private final Provider<EventMasterDatabase> databaseProvider;

  public DatabaseModule_ProvideEventRepositoryFactory(
      Provider<EventMasterDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public EventRepository get() {
    return provideEventRepository(databaseProvider.get());
  }

  public static DatabaseModule_ProvideEventRepositoryFactory create(
      javax.inject.Provider<EventMasterDatabase> databaseProvider) {
    return new DatabaseModule_ProvideEventRepositoryFactory(Providers.asDaggerProvider(databaseProvider));
  }

  public static DatabaseModule_ProvideEventRepositoryFactory create(
      Provider<EventMasterDatabase> databaseProvider) {
    return new DatabaseModule_ProvideEventRepositoryFactory(databaseProvider);
  }

  public static EventRepository provideEventRepository(EventMasterDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideEventRepository(database));
  }
}
